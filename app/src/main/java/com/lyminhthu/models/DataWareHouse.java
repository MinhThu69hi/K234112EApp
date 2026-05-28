package com.lyminhthu.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DataWareHouse {
    public static ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        Category g1 = new Category("c1", "Mì các loại", "Mì chống đói");
        Category g2 = new Category("c2", "Bánh kẹo", "Kẹo Hạnh Phúc");
        Category g3 = new Category("c3", "Nước uống", "Nước uống có ga");
        Category g4 = new Category("c4", "Thịt", "Thịt Heo");
        Category g5 = new Category("c5", "Trái cây", "Trái cây Vietgap");
        categories.add(g1);
        categories.add(g2);
        categories.add(g3);
        categories.add(g4);
        categories.add(g5);
        return categories;
    }

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Category> categories = getCategories();

        // Mì các loại (c1)
        products.add(new Product("p1", "Mì Omachi xốt bò hầm", 100, 15000, 0, 0.05, categories.get(0).getCategoryid()));
        products.add(new Product("p2", "Mì Hảo Hảo tôm chua cay", 200, 4500, 0, 0.05, categories.get(0).getCategoryid()));
        products.add(new Product("p3", "Mì Indomie Mi Goreng", 150, 6000, 0, 0.05, categories.get(0).getCategoryid()));
        products.add(new Product("p4", "Mì Cung Đình sườn hầm", 120, 12000, 0, 0.05, categories.get(0).getCategoryid()));

        // Bánh kẹo (c2)
        products.add(new Product("p5", "Kẹo KitKat", 50, 25000, 0.1, 0.1, categories.get(1).getCategoryid()));
        products.add(new Product("p6", "Bánh ChocoPie", 80, 50000, 0.05, 0.1, categories.get(1).getCategoryid()));
        products.add(new Product("p7", "Kẹo Alpenliebe caramel", 100, 10000, 0, 0.1, categories.get(1).getCategoryid()));
        products.add(new Product("p8", "Bánh Oreo Original", 70, 18000, 0, 0.1, categories.get(1).getCategoryid()));

        // Nước uống (c3)
        products.add(new Product("p9", "Coca Cola 330ml", 300, 10000, 0, 0.1, categories.get(2).getCategoryid()));
        products.add(new Product("p10", "Nước suối Aquafina 500ml", 500, 5000, 0, 0.1, categories.get(2).getCategoryid()));
        products.add(new Product("p11", "Trà xanh C2", 150, 8000, 0, 0.1, categories.get(2).getCategoryid()));
        products.add(new Product("p12", "Sữa tươi Vinamilk", 100, 35000, 0.05, 0.1, categories.get(2).getCategoryid()));

        // Thịt (c4)
        products.add(new Product("p13", "Thịt ba chỉ heo", 30, 150000, 0, 0.05, categories.get(3).getCategoryid()));
        products.add(new Product("p14", "Bắp bò Úc", 20, 250000, 0, 0.05, categories.get(3).getCategoryid()));
        products.add(new Product("p15", "Ức gà phi lê", 40, 80000, 0, 0.05, categories.get(3).getCategoryid()));

        // Trái cây (c5)
        products.add(new Product("p16", "Táo Envy Mỹ", 50, 120000, 0.1, 0.05, categories.get(4).getCategoryid()));
        products.add(new Product("p17", "Nho xanh không hạt", 40, 180000, 0, 0.05, categories.get(4).getCategoryid()));
        products.add(new Product("p18", "Cam xoàn miền Tây", 60, 45000, 0, 0.05, categories.get(4).getCategoryid()));
        products.add(new Product("p19", "Chuối Dole", 100, 30000, 0, 0.05, categories.get(4).getCategoryid()));

        return products;
    }

    public static ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("e1", "Nguyễn Văn A", "0123456789", "Hà Nội"));
        employees.add(new Employee("e2", "Trần Thị B", "0987654321", "TP. Hồ Chí Minh"));
        employees.add(new Employee("e3", "Lê Văn C", "0912345678", "Đà Nẵng"));
        employees.add(new Employee("e4", "Phạm Thị D", "0905123456", "Cần Thơ"));
        employees.add(new Employee("e5", "Hoàng Văn E", "0944112233", "Hải Phòng"));
        employees.add(new Employee("e6", "Vũ Thị F", "0977889900", "Huế"));
        employees.add(new Employee("e7", "Đặng Văn G", "0966554433", "Nha Trang"));
        employees.add(new Employee("e8", "Bùi Thị H", "0933221100", "Đà Lạt"));
        employees.add(new Employee("e9", "Ngô Văn I", "0922334455", "Biên Hòa"));
        employees.add(new Employee("e10", "Lý Thị K", "0955667788", "Vũng Tàu"));
        return employees;
    }

    public static ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        String[] lastNames = {"Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Huỳnh", "Phan", "Vũ", "Võ", "Đặng"};
        String[] middleNames = {"Văn", "Thị", "Anh", "Minh", "Thu", "Ngọc", "Hoàng", "Quang", "Đức"};
        String[] firstNames = {"Tèo", "Tí", "Hùng", "Lan", "Hoa", "Dũng", "Tuấn", "Linh", "Hạnh", "Cường", "Trang", "Sơn"};
        String[] provinces = {"Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "Cần Thơ", "Hải Phòng", "Bình Dương", "Đồng Nai", "Long An", "Tiền Giang"};

        // Sử dụng seed cố định để danh sách luôn cố định mỗi lần chạy (phục vụ demo)
        Random random = new Random(1234);
        Calendar cal = Calendar.getInstance();

        for (int i = 1; i <= 100; i++) {
            String id = "cus" + i;
            String name = lastNames[random.nextInt(lastNames.length)] + " " +
                    middleNames[random.nextInt(middleNames.length)] + " " +
                    firstNames[random.nextInt(firstNames.length)];
            String phone = "09" + String.format("%08d", random.nextInt(100000000));
            String email = "customer" + i + "@gmail.com";

            // Random năm sinh từ 1965 đến 2010
            int year = 1965 + random.nextInt(2010 - 1965 + 1);
            int month = random.nextInt(12);
            int day = random.nextInt(28) + 1;
            cal.set(year, month, day);

            String address = provinces[random.nextInt(provinces.length)];

            customers.add(new Customer(id, name, phone, email, cal.getTime(), address));
        }
        return customers;
    }
    public static ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Customer> customers = getCustomers();
        ArrayList<Employee> employees = getEmployees();

        if (customers.isEmpty() || employees.isEmpty()) return orders;

        // Sử dụng seed cố định để dữ liệu luôn đồng nhất
        Random random = new Random(789);
        Calendar cal = Calendar.getInstance();

        // Khoảng thời gian: từ 01/01/2024 đến 31/03/2026 (hết Q1 2026)
        cal.set(2024, Calendar.JANUARY, 1, 0, 0, 0);
        long startMillis = cal.getTimeInMillis();

        cal.set(2026, Calendar.MARCH, 31, 23, 59, 59);
        long endMillis = cal.getTimeInMillis();
        long diffMillis = endMillis - startMillis;

        for (int i = 1; i <= 1000; i++) {
            String orderId = "od" + i;
            // Chọn khách hàng ngẫu nhiên
            String customerId = customers.get(random.nextInt(customers.size())).getCusId();
            // Phân bổ nhân viên đều bằng cách xoay vòng (modulo)
            String employeeId = employees.get((i - 1) % employees.size()).getId();

            // Sinh ngày ngẫu nhiên trong khoảng
            long randomMillis = startMillis + (long) (random.nextDouble() * diffMillis);
            Date orderDate = new Date(randomMillis);

            orders.add(new Order(orderId, customerId, employeeId, orderDate));
        }

        return orders;
    }

    public static ArrayList<OrderDetail> getOrderDetail() {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        ArrayList<Product> products = getProducts();
        ArrayList<Order> orders = getOrders();

        if (products.isEmpty() || orders.isEmpty()) return orderDetails;

        Random random = new Random(456);
        int detailCounter = 1;

        for (Order order : orders) {
            // Mỗi order có từ 1 đến 10 OrderDetail
            int numberOfDetails = random.nextInt(10) + 1;

            for (int i = 0; i < numberOfDetails; i++) {
                // Chọn sản phẩm ngẫu nhiên
                Product product = products.get(random.nextInt(products.size()));

                String detailId = "dt" + detailCounter++;
                String orderId = order.getOrderId();
                String productId = product.getProductId();

                // Số lượng ngẫu nhiên từ 1 đến 5
                int quantity = random.nextInt(5) + 1;

                // Đơn giá lấy từ sản phẩm (có thể biến động nhẹ nếu muốn, ở đây lấy khớp sản phẩm)
                double price = product.getPrice();

                // Coupon và VAT chia sẵn cho 100 (ví dụ 5% -> 0.05)
                // Coupon từ 0% đến 15%
                double coupon = random.nextInt(16) / 100.0;
                // VAT từ 5% đến 10%
                double vat = (random.nextInt(6) + 5) / 100.0;

                orderDetails.add(new OrderDetail(detailId, orderId, productId, quantity, price, coupon, vat));
            }
        }

        return orderDetails;
    }
    public static double sumOfMoney(Order od)
    {
        double sum = 0;
        ArrayList<OrderDetail> details = getOrderDetail();
        for (OrderDetail detail : details) {
            if (detail.getOrderId().equals(od.getOrderId())) {
                // Tính thành tiền cho mỗi chi tiết hóa đơn
                double lineTotal = detail.getPrice() * detail.getQuantity();
                // Trừ đi giảm giá (coupon)
                double afterDiscount = lineTotal * (1 - detail.getCoupon());
                // Cộng thêm thuế VAT (tính trên giá sau khi đã giảm)
                double finalAmount = afterDiscount * (1 + detail.getVAT());
                
                sum += finalAmount;
            }
        }
        return sum ;
    }
}

