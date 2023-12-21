/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.Dvoraninovich_Lab3.retailapp.domain.mock;

import com.Dvoraninovich_Lab3.retailapp.model.CenterRepository;
import com.Dvoraninovich_Lab3.retailapp.model.entities.Product;
import com.Dvoraninovich_Lab3.retailapp.model.entities.ProductCategoryModel;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class serve as fake server and provides dummy product and category with real Image Urls taken from flipkart
 */
public class ItemsList {

    private static ItemsList fakeServer;

    public static ItemsList getFakeWebServer() {

        if (null == fakeServer) {
            fakeServer = new ItemsList();
        }
        return fakeServer;
    }

    void initiateFakeServer() {

        addCategory();

    }

    public void addCategory() {

        ArrayList<ProductCategoryModel> listOfCategory = new ArrayList<ProductCategoryModel>();

        listOfCategory
                .add(new ProductCategoryModel(
                        "Clothing",
                        "All seasons",
                        "10%",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/6c24606a503a41c19fb6afa3012dd961_faec/adidas_Basketball_Velour_Pants_Gender_Neutral_Grey_IA3453_HM1.jpg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Shoes",
                        "All seasons",
                        "15%",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/c55c0f09308249daa771af9e01668066_9366/Top_Ten_LP_Shoes_White_IE7240_01_standard.jpg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Kids",
                        "All seasons",
                        "20%",
                        "https://brand.assets.adidas.com/image/upload/f_auto,q_auto,fl_lossy/if_w_gt_800,w_800/enUS/Images/xcat-fw22-holiday-tc-youth-d_tcm221-1069662.jpg"));
        CenterRepository.getCenterRepository().setListOfCategory(listOfCategory);
    }

    public void getAllElectronics() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // computers
        productlist
                .add(new Product(
                        "SWEATSHIRT",
                        "ADICOLOR CONTEMPO CREW SWEATSHIRT",
                        "The cotton in this product has been sourced through Better Cotton. Better Cotton is sourced via a chain of custody model called mass balance. This means that Better Cotton is not physically traceable to end products.",
                        "5490",
                        "10",
                        "4290",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/7025d8f9d221431087c5ae3f01503777_9366/Adicolor_Contempo_Crew_Sweatshirt_Black_HK0306_21_model.jpg",
                        "oven_1"));

        productlist
                .add(new Product(
                        "CREW",
                        "ADICOLOR CLASSICS 3-STRIPES CREW",
                        "This sweatshirt is classic Originals style with an Adicolor twist. Rooted in our heritage yet forward-thinking, it reinvents the familiar with contemporary cuts and design details. Subtle embroidered branding and iconic 3-Stripes down the sleeves mark it with sports heritage. Perfect for downtime or everyday adventures, the soft fleece settles you into comfort for the moments that matter.",
                        "5000",
                        "10",
                        "4290",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/6ad6a57446ea41da9859afd000e9b5c5_9366/Adicolor_Classics_3-Stripes_Crew_Blue_IM4515_21_model.jpg",
                        "oven_2"));



        productMap.put("Hoodies", productlist);

        ArrayList<Product> tvList = new ArrayList<Product>();

        // TV
        tvList.add(new Product(
                "JERSEY",
                "REAL MADRID 23/24 THIRD JERSEY",
                "occer elegance. It's hard to describe, but you know it when you see it. A nod to Real Madrid's sparkling away performances, the Real Madrid 23/24 Third Jersey keeps things classy with a black base and embroidered \"RMCF\" wording on the left side of the Henley collar. Sweat-wicking AEROREADY helps to keep you feeling dry, while mesh details add to the comfort for stellar performances on the pitch.",
                "600",
                "0",
                "400",
                "0",
                "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/622cae1412944d4090c0756d3ed31af8_9366/Real_Madrid_23-24_Third_Jersey_Black_IN9846_HM1.jpg",
                "tv_1"));

        tvList.add(new Product(
                "TEE",
                "MESSI TEE",
                "Messi and Miami. The perfect match. Displaying soccer superstar Lionel Messi's logo and number, this adidas tee is ready for kickoff. Perfect for watching his jaw-dropping play or for hanging out with friends, it's built with single jersey fabric for day-long comfort.",
                "17000",
                "12",
                "13990",
                "0",
                "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/61b7f9adf60d41b39cadd0e3055105c3_9366/Messi_Tee_Black_JG8862_21_model.jpg",
                "tv_2"));



        productMap.put("T-shirts", tvList);

        productlist = new ArrayList<Product>();

        // Consoles
        productlist
                .add(new Product(
                        "PANTS",
                        "TIRO 23 LEAGUE PANTS",
                        "Born for the beautiful game. Part of the Tiro 23 League range, these adidas soccer pants use AEROREADY to channel moisture away from your skin and keep you firing on all cylinders. Ankle zips mean they're easy to slide off when your session is done.",
                        "1500",
                        "10",
                        "1300",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/f13f36ab641e4591ab85aefc00f2a99e_9366/Tiro_23_League_Pants_Red_HS3528_21_model.jpg",
                        "v_cleaner_1"));

        productlist
                .add(new Product(
                        "CARGO PANTS",
                        "CITY ESCAPE CARGO PANTS",
                        "In these adidas cargo pants, you're prepared for any challenge, from rocky trails to crowded city streets. Brushed fabric on the inside keeps you comfortable. The loose fit through the legs shows off a stylish, oversized silhouette and allows for easy movement. Stow your gear in the cargo pockets before you set off.",
                        "900",
                        "10",
                        "700",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/e0ddcd18d4544e17b7cb14b6ebbfd547_9366/City_Escape_Cargo_Pants_Black_IJ6086_21_model.jpg",
                        "v_cleaner_2"));

        productlist
                .add(new Product(
                        "PANTS",
                        "SCRIBBLE FLEECE PANTS",
                        "Celebrate your achievements in style with these Scribble Fleece Pants. Inspired by the symbol of accomplishment — the collegiate jacket — they're designed for people who are always on the move. Express your individuality and show you belong with sport-inspired graphics and embroidery. Whether you're heading back to school or you're off on winter break, their soft cotton blend and relaxed fit are primed for comfort and making memories.",
                        "1500",
                        "10",
                        "1000",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/602f06dfbdfa415893caafc300ca92ad_9366/Scribble_Fleece_Pants_Black_HY1288_21_model.jpg",
                        "v_cleaner_3"));


        productMap.put("Pants", productlist);


        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllFurnitures() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // Table
        productlist
                .add(new Product(
                        "SUPERNOVA 3 RUNNING SHOES",
                        "Lace closure\n" +
                                "Mesh upper\n" +
                                "Textile lining\n" +
                                "Bounce midsole\n" +
                                "BOOST midsole\n" +
                                "Weight: 10 ounces (size 9)",
                        "Midsole drop: 9 mm (heel: 25 mm / forefoot: 16 mm)\n" +
                                "Rubber outsole\n" +
                                "Upper contains a minimum of 50% recycled content; Carbon footprint reduced by 19%, compared to previous versions.\n" +
                                "Imported\n" +
                                "Product color: Cloud White / Lucid Lemon / Arctic Fusion\n" +
                                "Product code: HQ1806",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/e8d33874b9d149f6b345d938877059c4_9366/Supernova_3_Running_Shoes_White_HQ1806_HM1.jpg",
                        "table_1"));

        productlist
                .add(new Product(
                        "PUREBOOST 23 RUNNING SHOES",
                        "ENERGY-RETURNING RUNNING SHOES MADE IN PART WITH RECYCLED MATERIALS.",
                        "This product features at least 20% recycled materials. By reusing materials that have already been created, we help to reduce waste and our reliance on finite resources and reduce the footprint of the products we make.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/0cb8d7b276cc47da94a6e60ecd335ae3_9366/Pureboost_23_Running_Shoes_Black_IF2375_01_standard.jpg",
                        "table_2"));



        productMap.put("Summer", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "TERREX",
                        "UNITY LEATHER MID RAIN.RDY HIKING SHOES",
                        "Made in part with recycled content generated from production waste, e.g. cutting scraps, and post-consumer household waste to avoid the larger environmental impact of producing virgin content.",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/b6b78ed355bd4db6aedcaed300cc7b87_9366/Unity_Leather_Mid_RAIN.RDY_Hiking_Shoes_Beige_GZ3969_01_standard.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "TERREX",
                        "TERREX FREE HIKER 2 BCA HIKING SHOE",
                        "Take on the outdoors with ease. The adidas TERREX Free Hiker 2 brings comfort and confidence to your everyday adventure. It's time to enjoy your outdoor experience.",
                        "500",
                        "20",
                        "200",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/1a2a5bc470384787819daeda0091896d_9366/TERREX_Free_Hiker_2_BCA_Hiking_Shoe_Purple_GZ0684_01_standard.jpg",
                        "chair_2"));





        productMap.put("Autumn", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "Running",
                        "SWITCH FWD RUNNING SHOES",
                        "Midsole drop: 10 mm (heel: 44.8 mm / forefoot: 34.8 mm)\n" +
                                "Continental™ Rubber outsole\n" +
                                "Upper contains a minimum of 50% recycled content\n" +
                                "Imported\n" +
                                "Product color: Linen Green / Zero Metalic / Lucid Lemon\n" +
                                "Product code: IG0674",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/36fee312e3ab4b149cb22982d282b852_9366/Switch_FWD_Running_Shoes_Green_IG0674_HM1.jpg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "BMW X7 M60i xDrive",
                        "ULTRABOOST LIGHT RUNNING SHOES",
                        "Experience epic energy with the new Ultraboost Light, our lightest Ultraboost ever. The magic lies in the Light BOOST midsole, a new generation of adidas BOOST. Its unique molecule design achieves the lightest BOOST foam to date. With hundreds of BOOST capsules bursting with energy and ultimate cushioning and comfort, some feet really can have it all.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9fc33404c64d4b8db52af275add6b62e_9366/Ultraboost_Light_Running_Shoes_White_IE1768_01_standard.jpg",
                        "almirah_2"));



        productMap.put("Running", productlist);

        productMap.put("Running", productlist);

        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllProducts(int productCategory) {

        if (productCategory == 0) {

            getAllElectronics();
        } else {

            getAllFurnitures();

        }

    }

}
