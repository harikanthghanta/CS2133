/**
 * Created by kyle on 3/15/15.
 */
public class Test {
    public static void main(String[] args){
        //UrlFormatter urlFormatter = new UrlFormatter();
        //System.out.println(urlFormatter.createRequest());

        UrlRequest urlRequest = new UrlRequest();
        System.out.println(urlRequest.downloadRawHtml("casnr.okstate.edu/future-students"));
    }
}