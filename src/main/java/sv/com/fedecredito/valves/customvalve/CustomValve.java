/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.fedecredito.valves.customvalve;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 *
 * @author xtecuan
 */
public class CustomValve extends ValveBase {

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {

        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        response.setHeader("X-XSS-Protection", "1; mode=block");
        response.setHeader("X-Content-Type-Options", "nosniff");
        response.setHeader("Referrer-Policy", "strict-origin");
        //response.setHeader("Content-Security-Policy", "default-src 'self'; font-src *;img-src * data:; script-src *; style-src *;");
        getNext().invoke(request, response);
    }
}
