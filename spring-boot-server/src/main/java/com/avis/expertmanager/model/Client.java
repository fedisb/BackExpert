package com.avis.expertmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String contactName;
    private String email;
    private String phone;

    private String companyName;
    private String imageUrl;
    private String domaineOffer;

    private  String offerDescription;
    private  Number tjm;
    private String profileType;



    public Client() {
    }

    public Client(Long id, String contactName, String email, String companyName, String phone, String imageUrl, String offerDescription, String domaineOffer, Number tjm) {
        this.id = id;
        this.contactName = contactName;
        this.email = email;
        this.companyName = companyName;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.offerDescription = offerDescription;
        this.domaineOffer = domaineOffer;
        this.profileType = profileType;
        this.tjm = tjm ;
    }

    public Client(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDomaineOffer() {
        return domaineOffer;
    }

    public void setDomaineOffer(String domaineOffer) {
        this.domaineOffer = domaineOffer;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public Number getTjm() {
        return tjm;
    }

    public void setTjm(Number tjm) {
        this.tjm = tjm;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    @Override
    public String toString(){
        return "Expert{" +
                "id=" + id +
                ", contactName='" + contactName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", companyName='" + companyName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", offerDescription='" +offerDescription + '\'' +
                ", domaine='" +domaineOffer + '\'' +
                ", profileType='" +profileType + '\'' +
                ", tjm='" +tjm + '\'' +
                '}';
    }

}

