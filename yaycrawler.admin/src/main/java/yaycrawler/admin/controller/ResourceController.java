package yaycrawler.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yaycrawler.dao.domain.SiteCookie;
import yaycrawler.dao.repositories.SiteCookieRepository;

/**
 * Created by ucs_yuananyun on 2016/5/18.
 */
@RestController
public class ResourceController {

    @Autowired
    private SiteCookieRepository cookieRepository;

    @RequestMapping(value = "/addCookie", method = RequestMethod.POST)
    public Object addCookie(String siteId, String domain, String cookie) {
        Assert.notNull(siteId);
        Assert.notNull(domain);
        Assert.notNull(cookie);
        return cookieRepository.save(new SiteCookie(siteId, domain, cookie));
    }

}
