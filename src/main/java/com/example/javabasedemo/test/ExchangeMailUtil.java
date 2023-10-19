package com.example.javabasedemo.test;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

import java.net.URI;
import java.net.URISyntaxException;

public class ExchangeMailUtil {
    public static void main(String[] args) throws Exception {
        ExchangeMailUtil mailUtil = new ExchangeMailUtil("https://mail.maxwealthfund.com/EWS/exchange.asmx",
                "equity_report@maxwealthfund.com", "abcd@1234");

    }
    private String mailServer;
    private String user;
    private String password;
    private String domain;

    public ExchangeMailUtil(String mailServer, String user, String password) {
        this.mailServer = mailServer;
        this.user = user;
        this.password = password;
    }

    public ExchangeMailUtil(String mailServer, String user, String password, String domain) {
        this.mailServer = mailServer;
        this.user = user;
        this.password = password;
        this.domain = domain;
    }

    private ExchangeService getExchangeService() {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2007_SP1);
        //用户认证信息
        ExchangeCredentials credentials;
        if (domain == null) {
            credentials = new WebCredentials(user, password);
        } else {
            credentials = new WebCredentials(user, password, domain);
        }
        service.setCredentials(credentials);
        try {
            service.setUrl(new URI(mailServer));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return service;
    }

    public void send(String subject, String[] to, String[] cc, String bodyText, String[] attachmentPaths)
            throws Exception {
        ExchangeService service = getExchangeService();

        EmailMessage msg = new EmailMessage(service);
        msg.setSubject(subject);
        MessageBody body = MessageBody.getMessageBodyFromText(bodyText);
        body.setBodyType(BodyType.HTML);
        msg.setBody(body);
        for (String toPerson : to) {
            msg.getToRecipients().add(toPerson);
        }
        if (cc != null) {
            for (String ccPerson : cc) {
                msg.getCcRecipients().add(ccPerson);
            }
        }
        if (attachmentPaths != null) {
            for (String attachmentPath : attachmentPaths) {
                msg.getAttachments().addFileAttachment(attachmentPath);
            }
        }
        msg.send();
    }

    /**
     * 发送不带附件的mail
     *
     * @param subject  邮件标题
     * @param to       收件人列表
     * @param cc       抄送人列表
     * @param bodyText 邮件内容
     * @throws Exception
     */
    public void send(String subject, String[] to, String[] cc, String bodyText) throws Exception {
        send(subject, to, cc, bodyText, null);
    }

    public void getDeleteEmail(){
        ExchangeService service = getExchangeService();
    };
}
