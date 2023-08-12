package com.undecided.gfw.web.logging.mdc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;
import java.util.regex.Pattern;

public class XTrackMDCPutFilter extends AbstractMDCPutFilter {

    private static final Pattern UUID_REPLACE_PATTERN = Pattern.compile("-");

    private String attributeName = "X-Track";

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;

    }

    @Override
    protected String getMDCKey(HttpServletRequest request,
                               HttpServletResponse response) {
        return attributeName;
    }

    protected String createXTrack() {
        String uuid = UUID.randomUUID().toString();
        String xTrack = UUID_REPLACE_PATTERN.matcher(uuid).replaceAll("");
        return xTrack;
    }

    @Override
    protected String getMDCValue(HttpServletRequest request,
                                 HttpServletResponse response) {
        String xTrack = request.getHeader(attributeName);
        if (xTrack == null) {
            xTrack = createXTrack();
        }
        String cutXTrack = cutValue(xTrack);
        response.setHeader(attributeName, cutXTrack);
        request.setAttribute(attributeName, cutXTrack);
        return cutXTrack;
    }
}
