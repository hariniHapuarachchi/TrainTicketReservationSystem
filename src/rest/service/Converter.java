package rest.service;

import rest.dto.*;
import rest.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof SignIn) {
            SignIn s = (SignIn) entity;
            return (T) new SignInDTO(s.getId(), s.getName(), s.getEmail(), s.getStatus(), s.getNic(), s.getPassword());
        }else if (entity instanceof Reservation) {
            Reservation r = (Reservation) entity;
            return (T) new ReservationDTO(r.getReserveId(),r.getId(),r.getDate(),r.getTime(),r.getTicket(),r.getAmount(),r.getPayMethod());
        }else if (entity instanceof Login) {
            Login l = (Login) entity;
            return (T) new LoginDTO(l.getLoginTime(),l.getId(),l.getLogoutTime());
        }else if (entity instanceof Payment) {
            Payment p = (Payment) entity;
            return (T) new PaymentDTO(p.getId(),p.getReserveId(),p.getCreditCard(),p.getCvcNo(),p.getName(),p.getMobile(),p.getDigitNum());
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof SignInDTO) {
            SignInDTO s = (SignInDTO) dto;
            return (T) new SignIn(s.getId(), s.getName(), s.getEmail(), s.getStatus(), s.getNic(), s.getPassword());
        } else if (dto instanceof ReservationDTO) {
            ReservationDTO r = (ReservationDTO) dto;
            return (T) new Reservation(r.getReserveId(),r.getId(), r.getDate(), r.getTime(), r.getTicket(), r.getAmount(), r.getPayMethod());
        }else if (dto instanceof LoginDTO) {
            LoginDTO l = (LoginDTO) dto;
            return (T) new Login(l.getLoginTime(),l.getId(),l.getLogoutTime());
        }else if (dto instanceof PaymentDTO) {
            PaymentDTO p = (PaymentDTO) dto;
            return (T) new Payment(p.getId(),p.getReserveId(),p.getCreditCard(),p.getCvcNo(),p.getName(),p.getMobile(),p.getDigitNum());
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

//    public static <T extends SuperDTO> List<T> getDTOList(List<CustomEntity> list, Class<T> dtoClass) {
//        return list.stream().map(c -> getDTO(c, dtoClass)).collect(Collectors.toList());
//    }
}
