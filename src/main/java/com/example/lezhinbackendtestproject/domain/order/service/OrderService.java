package com.example.lezhinbackendtestproject.domain.order.service;

import com.example.lezhinbackendtestproject.domain.order.dto.request.OrderRequest;
import com.example.lezhinbackendtestproject.domain.order.dto.response.OrderResponse;
import com.example.lezhinbackendtestproject.entity.artwork.Artwork;
import com.example.lezhinbackendtestproject.entity.order.Order;
import com.example.lezhinbackendtestproject.entity.user.User;
import com.example.lezhinbackendtestproject.global.response.error.codes.ApiErrorCode;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import com.example.lezhinbackendtestproject.repository.artwork.ArtworkRepository;
import com.example.lezhinbackendtestproject.repository.event.EventRepository;
import com.example.lezhinbackendtestproject.repository.order.OrderRepository;
import com.example.lezhinbackendtestproject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final ArtworkRepository artworkRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public OrderResponse.Data processOrderPost(OrderRequest request){
        //작품이 있는지 체크
        Optional<Artwork> artwork = artworkRepository.findArtworkByArtworkCode(request.getArtworkCode());
        if(artwork.isEmpty()){
            throw new RestBusinessException(ApiErrorCode.ARTWORK_NOT_FOUND);
        }
        //유저 맞는지 체크
        Optional<User> user = userRepository.findByUserId(request.getUserId());
        if(user.isEmpty()){
            throw new RestBusinessException(ApiErrorCode.USER_NOT_FOUND);
        }
        //작품이 무료인지 유료인지 체크
        boolean isFree = false;
        // 첫번째로 일단 해당 작품이 이벤트 기간안에 무료인지 체크
        if(eventRepository.isEventRangeCheck(request.getArtworkCode())){
            isFree = true;
        }else {
            //그외는 작품에 설정된 무료 유료를 체크 한다.
            isFree = Objects.equals(artwork.get().getFreeYn(), "Y");
        }
        //작퓸의 가격이 무료이면 0원을 리턴
        BigDecimal orderPrice = isFree ? BigDecimal.valueOf(0) :artwork.get().getPrice();

        Order order = orderRepository.save(Order.toEntity(
                generateOrderId(),  //주문번호
                request.getArtworkCode(),
                request.getArtworkCode(),
                orderPrice));
        //리턴
        return OrderResponse.Data.toResult(order);
    }
    //주문번호 생성
    private String generateOrderId() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "OR"+timestamp +UUID.randomUUID().toString().substring(0, 8);
    }


    public List<OrderResponse.OrderBestArtwork> findByOrderBestArtwork(){
        return orderRepository.findByOrderBestArtwork();
    }


}
