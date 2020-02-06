--получить список заказов на определенную дату
select * from hotel._order where hotel._order.date_arival = '2020-01-23';

--получить данные об определенном госте
select hotel.guest.* , hotel.room.room_number , hotel._order.date_arival ,
       hotel._order. date_depart , hotel._order.paid
from hotel.guest
left join hotel._order on hotel.guest.id = hotel._order.id_guest
left join hotel.room on hotel.room.id = hotel._order.id_room
left join hotel.service on hotel.service.id = hotel._order.id_service
where hotel._order.id_guest  = 1 ;

--получиь список заказанных сервисов
select * from hotel.service
left join hotel._order on hotel.service.id = hotel._order.id_service
where hotel._order.id_service is not null;

--получить оплаченные/неоплаченные зказы
select * from hotel._order, hotel.guest
where hotel._order.paid = true;

--Добавить гостя
INSERT into hotel.guest (last_name, first_name, cert_number, phone_number)
values ('Алексей', 'Алекеев', 494737, 89157884488)