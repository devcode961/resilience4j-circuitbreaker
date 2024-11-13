package com.example.circuitbreaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 * "id": "b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0",
 * "name": "MadTree Brewing 2.0",
 * "brewery_type": "regional",
 * "address_1": "5164 Kennedy Ave",
 * "address_2": null,
 * "address_3": null,
 * "city": "Cincinnati",
 * "state_province": "Ohio",
 * "postal_code": "45213",
 * "country": "United States",
 * "longitude": "-84.4137736",
 * "latitude": "39.1885752",
 * "phone": "5138368733",
 * "website_url": "http://www.madtreebrewing.com",
 * "state": "Ohio",
 * "street": "5164 Kennedy Ave"
 * }
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brewery {
    private String id;
    private String name;
    private String brewery_type;
    private String address_1;
    private String address_2;
    private String address_3;
    private String city;
    private String state_province;
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    private String website_url;
    private String state;
    private String street;
}
