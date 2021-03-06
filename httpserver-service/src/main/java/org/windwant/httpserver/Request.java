package org.windwant.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求对象
 * Created by windwant on 2016/6/12.
 */
public class Request {

    private InputStream in;

    public String getUri() {
        return uri;
    }

    private String uri;

    public Request(){}

    public Request(InputStream in){
        this.in = in;
    }

    /**
     * 请求内容读取
     */
    public void read(){
        StringBuffer sb = new StringBuffer();
        int i = 0;
        byte[] b = new byte[2048];
        try {
            i = in.read(b);
            for (int j = 0; j < i; j++) {
                sb.append((char)b[j]);
            }
            formatRequest(sb.toString());
            filterUri(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean read(SocketChannel channel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        StringBuffer sb = new StringBuffer();
        while (channel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            int lgn = byteBuffer.limit();
            for (int i = 0; i < lgn; i++) {
                sb.append((char) byteBuffer.get(i));
            }
            byteBuffer.clear();
        }
        if(sb.length() > 0) {
            filterUri(sb.toString());
            return true;
        }
        return false;
    }

    private String metod;
    private String path;
    private String scheme;
    private Map<String, String> argvs = new HashMap();

    public Map<String, String> getArgvs() {
        return argvs;
    }

    public void setArgvs(Map<String, String> argvs) {
        this.argvs = argvs;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMetod() {
        return metod;
    }

    public void setMetod(String metod) {
        this.metod = metod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void formatRequest(String request){
        if(request == null || request.length() == 0) return;
        String[] lines =request.split("\r\n");
        if(lines == null || lines.length == 0) return;
        String[] firstLine = lines[0].split(" ");
        if(firstLine == null || firstLine.length < 3) return;
        this.metod = firstLine[0];
        String[] paths = firstLine[1].split("\\?");
        this.path = paths[0];
        if(paths.length > 1){
            Arrays.asList(paths[1].split("&")).stream().forEach(item->{
                String[] kv = item.split("=");
                argvs.put(kv[0], kv.length > 1?kv[1]:"");
            });
        }
        this.scheme = firstLine[2];
    }

    public static void main(String[] args) {
        System.out.println("a".split("\\?")[0]);
    }
    /**
     * url 过滤
     * @param request
     */
    public void filterUri(String request){
        formatRequest(request);
        System.out.println("http request: " + request);
        if(!(path.endsWith(".html") || path.endsWith(".htm") || path.endsWith(".jpg") || path.endsWith(".png") || path.equals("upload"))){
            path = "/redirect.html";
            System.out.println("http request uri rewrite: " + path);
        }
    }

}
