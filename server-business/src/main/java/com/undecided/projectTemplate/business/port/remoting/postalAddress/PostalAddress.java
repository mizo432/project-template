package com.undecided.projectTemplate.business.port.remoting.postalAddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class PostalAddress {
// "postcode_type": "area",

    @JsonProperty("postcode_type")
    private String postcodeType;
    @JsonProperty("jis")
    private String jisAddressCode;
    @JsonProperty("new")
    private String postalCode;

    @JsonProperty("prefecture_kana")
    private String prefectureKana;
    @JsonProperty("city_kana")
    private String cityKana;

    @JsonProperty("suburb_kana")
    private String suburbKana;
    @JsonProperty("prefecture")
    private String prefecture;
    @JsonProperty("city")
    private String city;

    @JsonProperty("suburb")
    private String suburb;
    @JsonProperty("street_address")
    private String streetAddress;
    @JsonProperty("office")
    private String office;
    @JsonProperty("office_kana")
    private String officeKana;
    @JsonProperty("post_type")
    private String postType;

    @JsonProperty("is_separated_suburb")
    private boolean isSeparatedSuburb;
    @JsonProperty("is_koaza")
    private boolean isKoaza;
    @JsonProperty("is_chome")
    private boolean isChome;
    @JsonProperty("is_include_area")
    private boolean isIncludeArea;

    @JsonProperty("status")
    private int status;
    @JsonProperty("reason")
    private int reason;

    @JsonProperty("multiple_numbers")
    private String multipleNumbers;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
