package ru.cip.ipinfo;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class IpInfoController {

    public class IpInformation {
        public String userIP;
        public HttpHeaders headers;
        public String remoteAddress;
        public String remoteHost;
        public int remotePort;
        public String authType;
        public String pathInfo;
        public String queryString;
        public String remoteUser;
        public Principal principal;

        @Override
        public String toString() {
            return "IpInformation{" +
                    "userIP='" + userIP + '\'' +
                    ", headers=" + headers +
                    ", remoteAddress='" + remoteAddress + '\'' +
                    ", remoteHost='" + remoteHost + '\'' +
                    ", remotePort=" + remotePort +
                    ", authType='" + authType + '\'' +
                    ", pathInfo='" + pathInfo + '\'' +
                    ", queryString='" + queryString + '\'' +
                    ", remoteUser='" + remoteUser + '\'' +
                    ", principal=" + principal +
                    '}';
        }
    }

    @GetMapping("/getinfo")
    public IpInformation getInfo(@RequestHeader HttpHeaders headers, HttpServletRequest request) {
        IpInformation info = new IpInformation();
        info.headers = headers;
        info.remoteAddress = request.getRemoteAddr();
        info.remoteHost = request.getRemoteHost();
        info.remotePort = request.getRemotePort();
        info.authType = request.getAuthType();
        info.pathInfo = request.getPathInfo();
        info.queryString = request.getQueryString();
        info.remoteUser = request.getRemoteUser();
        info.principal = request.getUserPrincipal();
        System.out.println(info.toString());
        return info;
    }

}
