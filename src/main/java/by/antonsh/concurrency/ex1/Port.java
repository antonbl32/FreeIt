package by.antonsh.concurrency.ex1;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/*
Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число
контейнеров, находящихся в текущий момент в порту и на корабле, должно
быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов. У одного
причала может стоять один корабль. Корабль может загружаться у причала,
разгружаться или выполнять оба действия
 */
@Data
public class Port {
    private AtomicInteger countContainer = new AtomicInteger(350);
    private final int DOCKS = 5; //count of docks
    private final int MAXCONTAINER = 450;
}
