package com.pornlen.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the schedule database table.
 */
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private String id;

    @Column(length = 255)
    private String carrier;

    @Column(name = "carrier_description", length = 255)
    private String carrierDescription;

    private float density;

    @Column(name = "distribution_finished")
    private byte distributionFinished;

    @Column(length = 255)
    private String forwarder;

    @Column(name = "forwarder_description", length = 255)
    private String forwarderDescription;

    private int kilograms;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date", nullable = false)
    private Date lastModifiedDate;

    private int liters;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "loading_date")
    private Date loadingDate;

    @Column(name = "order_number")
    private BigInteger orderNumber;

    @Column(length = 255)
    private String pool;

    @Column(name = "pour_card_number", length = 255)
    private String pourCardNumber;

    @Column(length = 255)
    private String propane;

    @Column(length = 255)
    private String region;

    @Column(name = "reservation_number")
    private int reservationNumber;

    @Column(name = "route_number")
    private int routeNumber;

    @Column(name = "tds_number", length = 255)
    private String tdsNumber;

    private float temperature;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "unloading_date")
    private Date unloadingDate;

    @Column(name = "weight_after")
    private int weightAfter;

    @Column(name = "weight_amount_number", length = 255)
    private String weightAmountNumber;

    @Column(name = "weight_before")
    private int weightBefore;

    //bi-directional many-to-one association to Driver
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver")
    private Driver driverBean;

    //bi-directional many-to-one association to FuelType
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_type")
    private FuelType fuelTypeBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station")
    private Station station;

    //bi-directional many-to-one association to Terminal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terminal")
    private Terminal unloadTerminal;

    //bi-directional many-to-one association to Terminal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terminal")
    private Terminal loadTerminal;

    //bi-directional many-to-one association to Vehicle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck")
    private Vehicle vehicle1;

    //bi-directional many-to-one association to Vehicle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semi_trailer")
    private Vehicle vehicle2;

    public Schedule() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierDescription() {
        return this.carrierDescription;
    }

    public void setCarrierDescription(String carrierDescription) {
        this.carrierDescription = carrierDescription;
    }

    public float getDensity() {
        return this.density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public byte getDistributionFinished() {
        return this.distributionFinished;
    }

    public void setDistributionFinished(byte distributionFinished) {
        this.distributionFinished = distributionFinished;
    }

    public String getForwarder() {
        return this.forwarder;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public String getForwarderDescription() {
        return this.forwarderDescription;
    }

    public void setForwarderDescription(String forwarderDescription) {
        this.forwarderDescription = forwarderDescription;
    }

    public int getKilograms() {
        return this.kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getLiters() {
        return this.liters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public Date getLoadingDate() {
        return this.loadingDate;
    }

    public void setLoadingDate(Date loadingDate) {
        this.loadingDate = loadingDate;
    }

    public BigInteger getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(BigInteger orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPool() {
        return this.pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getPourCardNumber() {
        return this.pourCardNumber;
    }

    public void setPourCardNumber(String pourCardNumber) {
        this.pourCardNumber = pourCardNumber;
    }

    public String getPropane() {
        return this.propane;
    }

    public void setPropane(String propane) {
        this.propane = propane;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getReservationNumber() {
        return this.reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public int getRouteNumber() {
        return this.routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getTdsNumber() {
        return this.tdsNumber;
    }

    public void setTdsNumber(String tdsNumber) {
        this.tdsNumber = tdsNumber;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Date getUnloadingDate() {
        return this.unloadingDate;
    }

    public void setUnloadingDate(Date unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    public int getWeightAfter() {
        return this.weightAfter;
    }

    public void setWeightAfter(int weightAfter) {
        this.weightAfter = weightAfter;
    }

    public String getWeightAmountNumber() {
        return this.weightAmountNumber;
    }

    public void setWeightAmountNumber(String weightAmountNumber) {
        this.weightAmountNumber = weightAmountNumber;
    }

    public int getWeightBefore() {
        return this.weightBefore;
    }

    public void setWeightBefore(int weightBefore) {
        this.weightBefore = weightBefore;
    }

    public Driver getDriverBean() {
        return this.driverBean;
    }

    public void setDriverBean(Driver driverBean) {
        this.driverBean = driverBean;
    }

    public FuelType getFuelTypeBean() {
        return this.fuelTypeBean;
    }

    public void setFuelTypeBean(FuelType fuelTypeBean) {
        this.fuelTypeBean = fuelTypeBean;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Terminal getUnloadTerminal() {
        return unloadTerminal;
    }

    public void setUnloadTerminal(Terminal unloadTerminal) {
        this.unloadTerminal = unloadTerminal;
    }

    public Terminal getLoadTerminal() {
        return loadTerminal;
    }

    public void setLoadTerminal(Terminal loadTerminal) {
        this.loadTerminal = loadTerminal;
    }

    public Vehicle getVehicle1() {
        return this.vehicle1;
    }

    public void setVehicle1(Vehicle vehicle1) {
        this.vehicle1 = vehicle1;
    }

    public Vehicle getVehicle2() {
        return this.vehicle2;
    }

    public void setVehicle2(Vehicle vehicle2) {
        this.vehicle2 = vehicle2;
    }

}