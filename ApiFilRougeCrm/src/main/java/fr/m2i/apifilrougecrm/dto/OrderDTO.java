package fr.m2i.apifilrougecrm.dto;

public class OrderDTO {

    private Long id;
    private String typePresta;
    private String designation;
    private int nbDays;
    private float unitPrice;
    private String state; // CANCELLED:0 OPTION:1 CONFIRMED:2

    private CustomerDTO customer;

    public OrderDTO() {

    }

    public OrderDTO(String typePresta, String designation, int nbDays, float unitPrice) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customerDTO) {
        this.customer = customerDTO;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
