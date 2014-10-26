package com.pornlen.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by lolcat on 26.10.14.
 */
@javax.persistence.Entity
public class Schedule extends AbstractEntity {

    private Boolean distributionFinished;

    private Integer liters;

    private Integer routeNumber;

    private String tdsNumber;

    private String region;

    private String pool;

    private Integer reservationNumber;

    private Date loadingDate;

    private Date unloadingDate;

    private String forwarder;

    private String forwarderDescription;

    private String carrier;

    private String carrierDescription;

    private String weightAmountNumber;

    private Long orderNumber;

    private String pourCardNumber;

    private Integer weightBefore;

    private Integer weightAfter;

    private Integer kilogramsNumber;

    private Float density;

    private Float temperature;

    private String propane;

    @ManyToOne
    private Truck truck;

    @ManyToOne
    private Terminal terminal;

    @ManyToOne
    private Terminal unloadTerminal;

    @ManyToOne
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private SemiTrailer semiTrailer;

    @ManyToOne
    private Station station;

    @ManyToOne
    private Driver driver;

    public Schedule() {
    }

    public Boolean getDistributionFinished() {
        return distributionFinished;
    }

    public void setDistributionFinished(Boolean distributionFinished) {
        this.distributionFinished = distributionFinished;
    }

    public Integer getLiters() {
        return liters;
    }

    public void setLiters(Integer liters) {
        this.liters = liters;
    }

    public Integer getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Integer routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getTdsNumber() {
        return tdsNumber;
    }

    public void setTdsNumber(String tdsNumber) {
        this.tdsNumber = tdsNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public Integer getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(Integer reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(Date loadingDate) {
        this.loadingDate = loadingDate;
    }

    public Date getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(Date unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    public String getForwarder() {
        return forwarder;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public String getForwarderDescription() {
        return forwarderDescription;
    }

    public void setForwarderDescription(String forwarderDescription) {
        this.forwarderDescription = forwarderDescription;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierDescription() {
        return carrierDescription;
    }

    public void setCarrierDescription(String carrierDescription) {
        this.carrierDescription = carrierDescription;
    }

    public String getWeightAmountNumber() {
        return weightAmountNumber;
    }

    public void setWeightAmountNumber(String weightAmountNumber) {
        this.weightAmountNumber = weightAmountNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPourCardNumber() {
        return pourCardNumber;
    }

    public void setPourCardNumber(String pourCardNumber) {
        this.pourCardNumber = pourCardNumber;
    }

    public Integer getWeightBefore() {
        return weightBefore;
    }

    public void setWeightBefore(Integer weightBefore) {
        this.weightBefore = weightBefore;
    }

    public Integer getWeightAfter() {
        return weightAfter;
    }

    public void setWeightAfter(Integer weightAfter) {
        this.weightAfter = weightAfter;
    }

    public Integer getKilogramsNumber() {
        return kilogramsNumber;
    }

    public void setKilogramsNumber(Integer kilogramsNumber) {
        this.kilogramsNumber = kilogramsNumber;
    }

    public Float getDensity() {
        return density;
    }

    public void setDensity(Float density) {
        this.density = density;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public String getPropane() {
        return propane;
    }

    public void setPropane(String propane) {
        this.propane = propane;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SemiTrailer getSemiTrailer() {
        return semiTrailer;
    }

    public void setSemiTrailer(SemiTrailer semiTrailer) {
        this.semiTrailer = semiTrailer;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Terminal getUnloadTerminal() {
        return unloadTerminal;
    }

    public void setUnloadTerminal(Terminal unloadTerminal) {
        this.unloadTerminal = unloadTerminal;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}