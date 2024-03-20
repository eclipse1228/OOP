public class starbux {

    public class Coffie {
        private int price;
        private String name;
        private Object where;

        public Coffie(String name, int price) {
            this.price = price;
            this.name = name;
        }
        public void updatePlace(String name) {
            coffie.where = name;
        }

    }

    public class Client {
        private String name;
        private int money;

        public Client(String name, int money) {
            this.money = money;
            this.name = name;
        }

        public Order order(String CoffieName, int price) {
            Order order = new Order();
            order.orderCoffie(CoffieName,price);
            return order;
        }
    }

    public class Cacher {
        private static int money; // use static variable

        public Cacher(int money) {
            this.money = money;
        }

        public void sendToClient(Coffie coffie) {
            coffie.updatePlace("client");
        }
    }

    public class Baristar {
        public Baristar() {

        }
        // make Coffie
        public Coffie makeCoffie(Order order) {
            Coffie coffie = new Coffie(order.menuName,order.menuPrice);
            coffie.updatePlace("Cacher");
            return coffie;
        }


    }

    public class Order {
        private String menuName;
        private int menuPrice;

        public Order(String menuName, int menuPrice) {
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }

        // 이거 클라이언트가 order를 해야하는데 Order 객체를..
        public void orderCoffie(Coffie coffie,Cacher cacher) {
            // pay !
            client.money -= price;
            cacher.money += coffie.price;

            Order order = new Order(coffie.name, coffie.price);
        }

    }

    public static void main(String[] args) {

        Client client = new Client("ByeongSuGo",50000);
        Cacher cacher = new Cacher(100000);
        Baristar baristar = new Baristar();

        // 고객의 주문
        Order order = client.order("Hot Americano" ,5000);
        // 바리스타가 커피를 만들고 전달하기
        Coffie coffie = baristar.makeCoffie(order);
        // 그럼 손님에게 커피 전달 (주고 받는거니까, 있는지 없는지를 나타내는게 필요하다.)
        cacher.sendToClient(coffie);

    }
        // 캐셔가 손님에게 전달

}
