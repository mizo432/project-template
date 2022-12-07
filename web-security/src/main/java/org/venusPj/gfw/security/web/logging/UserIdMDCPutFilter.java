package org.venusPj.gfw.security.web.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.venusPj.gfw.web.logging.mdc.AbstractMDCPutFilter;

public class UserIdMDCPutFilter extends AbstractMDCPutFilter {

    private String attributeName = "USER";

    public void setAttributeName(String attibuteName) {
        this.attributeName = attibuteName;
    }

    @Override
    protected String getMDCKey(HttpServletRequest request,
        HttpServletResponse response) {
        return attributeName;
    }

    @Override
    protected String getMDCValue(HttpServletRequest request,
        HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            }
            return principal.toString();
        }

        return null;
    }

}
