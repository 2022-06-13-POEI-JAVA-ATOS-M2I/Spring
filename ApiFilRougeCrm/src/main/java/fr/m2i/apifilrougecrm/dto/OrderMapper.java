package fr.m2i.apifilrougecrm.dto;

import fr.m2i.apifilrougecrm.entity.Customer;
import fr.m2i.apifilrougecrm.entity.Order;

public class OrderMapper {

    public static OrderDTO buildOrderDTO(Order order) {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setTypePresta(order.getTypePresta());
        orderDTO.setDesignation(order.getDesignation());
        orderDTO.setNbDays(order.getNbDays());
        orderDTO.setUnitPrice(order.getUnitPrice());

        Customer customer = order.getCustomer();

        if (customer == null) {
            CustomerDTO customerDTO = CustomerMapper.buildCustomerDTO(customer);
            orderDTO.setCustomer(customerDTO);
        }

        switch (order.getState()) {
            case 0:
                orderDTO.setState("CANCELLED");
                break;
            case 1:
                orderDTO.setState("OPTION");
                break;
            case 2:
                orderDTO.setState("CONFIRMED");
                break;
            default:
                orderDTO.setState("");
        }

        return orderDTO;
    }

    public static Order buildOrder(OrderDTO orderDTO) {

        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setTypePresta(orderDTO.getTypePresta());
        order.setDesignation(orderDTO.getDesignation());
        order.setNbDays(orderDTO.getNbDays());
        order.setUnitPrice(orderDTO.getUnitPrice());

        if (orderDTO.getCustomer() != null && orderDTO.getCustomer().getId() != null) {
            order.setCustomer(new Customer(orderDTO.getCustomer().getId()));
        }

        if (orderDTO.getState() == null) {
            return order;
        }
        
        order.setState(stringtToState(orderDTO.getState()));

        return order;
    }

    public static Order copy(Order toUpdate, OrderDTO content) {

        if (content.getTypePresta() != null) {
            toUpdate.setTypePresta(content.getTypePresta());
        }

        if (content.getDesignation() != null) {
            toUpdate.setDesignation(content.getDesignation());
        }        
        
        if (content.getNbDays() != 0) {
            toUpdate.setNbDays(content.getNbDays());
        }
        
        if (content.getUnitPrice() != 0) {
            toUpdate.setUnitPrice(content.getUnitPrice());
        }

        if (content.getCustomer() != null && content.getCustomer().getId() != null) {
            toUpdate.setCustomer(new Customer(content.getCustomer().getId()));
        }

        if (content.getState() != null) {
            toUpdate.setState(stringtToState(content.getState()));
        }

        return toUpdate;
    }

    public static int stringtToState(String stateStr) {

        switch (stateStr) {
            case "CANCELLED":
                return 0;

            case "OPTION":
                return 1;

            case "CONFIRMED":
                return 2;

            default:
                return 0;
        }
    }
}
