/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.Grinevich_Lab3.retailapp.domain.mock;

import com.Grinevich_Lab3.retailapp.model.CenterRepository;
import com.Grinevich_Lab3.retailapp.model.entities.Product;
import com.Grinevich_Lab3.retailapp.model.entities.ProductCategoryModel;

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
                        "Пистолеты",
                        "CO2, GreenGas",
                        "10%",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/f9f/900_600_12f28b1e9c3c5899ab618b8ff44e28632/5399004e-dbe2-11e6-8035-94de8003c4f2_3dc993e2-2add-11ee-9cd0-00505687ed93.jpeg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Автоматы",
                        "GreenGas, Electric",
                        "15%",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/33e/900_600_12f28b1e9c3c5899ab618b8ff44e28632/c1dc40f4-9554-11ed-9de5-00505687ed93_9032aec7-4ae8-11ee-9e8c-00505687ed93.jpeg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Расходники",
                        "гранаты, 4.5мм, 6мм",
                        "20%",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/df2/900_600_12f28b1e9c3c5899ab618b8ff44e28632/1790d1fd-5c3d-11ea-9dd9-000c295b5c66_062440d0-7f98-11ea-9a71-000c295b5c66.jpeg"));
        CenterRepository.getCenterRepository().setListOfCategory(listOfCategory);
    }

    public void getAllElectronics() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // computers
        productlist
                .add(new Product(
                        "WE Glock 18C",
                        "Пистолет WE Glock 18C Gen.4 GGBB (GP617B)",
                        "Питание: заправка газом.\n" +
                                "Начальная скорость шарика: 95-105 м\\с.\n" +
                                "Емкость магазина: 26 шарика.\n" +
                                "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.",
                        "5490",
                        "10",
                        "4290",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/f87/900_600_12f28b1e9c3c5899ab618b8ff44e28632/8ef77df7-2661-11e3-a3b1-94de8003c4f2_fc98c572-06f5-11eb-98f1-000c295b5c66.jpeg",
                        "oven_1"));

        productlist
                .add(new Product(
                        "East Crane Glock 17 Gen 3",
                        "Пистолет East Crane Glock 17 Gen 3 (EC-1101-BK)",
                        "Питание: заправка газом.\n" +
                                "Начальная скорость шарика: 80 м\\с.\n" +
                                "Емкость магазина: 25 шариков.\n" +
                                "Резинки Maple Leaf не подходят на штатный стволик.\n" +
                                "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.",
                        "3000",
                        "10",
                        "4290",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/661/900_600_12f28b1e9c3c5899ab618b8ff44e28632/be11d2f3-2bab-11ea-bf41-000c295b5c66_347b66c6-1e63-11eb-98f1-000c295b5c66.jpeg",
                        "oven_2"));

        productlist
                .add(new Product(
                        "KJW Glock 17 CO2 GBB",
                        "Пистолет KJW Glock 17 CO2 GBB (CP611)",
                        "Питание: заправка газом.\n" +
                                "Начальная скорость шарика: 95 м\\с.\n" +
                                "Емкость магазина: 28 шариков.\n" +
                                "Резинки Maple Leaf не подходят на штатный стволик.\n" +
                                "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.",
                        "2000",
                        "10",
                        "4290",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/661/900_600_12f28b1e9c3c5899ab618b8ff44e28632/be11d2f3-2bab-11ea-bf41-000c295b5c66_347b66c6-1e63-11eb-98f1-000c295b5c66.jpeg",
                        "oven_3"));

        productlist
                .add(new Product(
                        "Cyma Glock 18",
                        "Пистолет Cyma Glock 18 custom AEP (CM127)",
                        "Питание: заправка газом.\n" +
                                "Начальная скорость шарика: 75 м\\с.\n" +
                                "Емкость магазина: 21 шарик.\n" +
                                "Резинки Maple Leaf не подходят на штатный стволик.\n" +
                                "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.",
                        "1000",
                        "10",
                        "4290",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/661/900_600_12f28b1e9c3c5899ab618b8ff44e28632/be11d2f3-2bab-11ea-bf41-000c295b5c66_347b66c6-1e63-11eb-98f1-000c295b5c66.jpeg",
                        "oven_4"));



        productMap.put("Glock серия", productlist);

        ArrayList<Product> tvList = new ArrayList<Product>();

        // TV
        tvList.add(new Product(
                "WE Colt 1911 GGBB",
                "Пистолет WE Colt 1911 GGBB (GP109)",
                "Питание: заправка газом.\n" +
                        "Начальная скорость шарика: 95-105 м\\с.\n" +
                        "Емкость магазина: 15 шарика.\n" +
                        "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.\n" +
                        "Комплектация: пистолет, инструкция, магазин.",
                "1600",
                "0",
                "400",
                "0",
                "https://airsoft-rus.ru/upload/resize_cache/iblock/583/900_600_12f28b1e9c3c5899ab618b8ff44e28632/ca9e1119-13d3-11e4-9f6b-d43d7e97909d_af3becdc-5a46-11eb-accc-000c295b5c66.jpeg",
                "tv_1"));

        tvList.add(new Product(
                "Tokyo Marui Hi-Capa 5.1 GGBB",
                "Пистолет Tokyo Marui Hi-Capa 5.1 GGBB (TM4952839142177)",
                "Пистолет работает на Green Gas, который заправляется в магазин. Количество выстрелов зависит от температуры и темпа стрельбы, но в среднем это 2 полных магазина.\n" +
                        "Органы управления (предохранитель, затворная задержка, кнопка сброса магазина) и неполная разборка копируют боевой аналог.\n" +
                        "У пистолета есть регулируемый хоп-ап. Два предохранителя: клавиша на тыльной части рукоятки и двухсторонний флажок в районе курка.",
                "17000",
                "12",
                "13990",
                "0",
                "https://airsoft-rus.ru/upload/resize_cache/iblock/b4f/900_600_12f28b1e9c3c5899ab618b8ff44e28632/9e6a668f-c459-11ec-8ded-00505687ed93_f3840b69-3d97-11ed-9ccc-00505687ed93.jpeg",
                "tv_2"));

        tvList.add(new Product(
                "WE Colt 1911 MEU SOC GGBB",
                "Пистолет WE Colt 1911 MEU SOC GGBB (GP111-SOC(OD))",
                "Питание: заправка газом.\n" +
                        "Начальная скорость шарика: 95-105 м\\с.\n" +
                        "Емкость магазина: 15 шариков.\n" +
                        "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.\n" +
                        "Комплектация: пистолет, инструкция, магазин.",
                "1600",
                "0",
                "400",
                "0",
                "https://airsoft-rus.ru/upload/resize_cache/iblock/ffe/900_600_12f28b1e9c3c5899ab618b8ff44e28632/ca9e112b-13d3-11e4-9f6b-d43d7e97909d_fc98c590-06f5-11eb-98f1-000c295b5c66.jpeg",
                "tv_3"));



        productMap.put("1911 серия", tvList);

        productlist = new ArrayList<Product>();

        // Consoles
        productlist
                .add(new Product(
                        "KWC Taurus PT-99",
                        "Пистолет KWC Taurus PT-99 (92) CO2 GBB (KCB-15AHN)",
                        "Питание от баллончиков СО2.\n" +
                                "Начальная скорость шарика: 120-130 м\\с.\n" +
                                "Емкость магазина: 30 шариков.\n" +
                                "Не рекомендуется хранить магазин с установленным баллончиком CO2.\n" +
                                "Комплектация: пистолет, инструкция, магазин, пакет с шариками для теста.",
                        "1500",
                        "10",
                        "1300",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/e45/900_600_12f28b1e9c3c5899ab618b8ff44e28632/494f9c91-13bc-11e4-b303-d43d7e97909d_c1e03768-8efc-11ec-9c81-00505687ed93.jpeg",
                        "v_cleaner_1"));

        productlist
                .add(new Product(
                        "WE Beretta M92",
                        "Пистолет WE Beretta M92 CO2 GBB (CP301)",
                        "Питание от баллончиков СО2.\n" +
                                "Начальная скорость шарика: 95-105 м\\с.\n" +
                                "Емкость магазина: 25 шариков.\n" +
                                "Не рекомендуется хранить магазин с установленным баллончиком CO2.\n" +
                                "Комплектация: пистолет, инструкция, магазин.",
                        "900",
                        "10",
                        "700",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/373/900_600_12f28b1e9c3c5899ab618b8ff44e28632/cb9ac864-b02d-11e3-9725-d43d7e97909d_c1e03764-8efc-11ec-9c81-00505687ed93.jpeg",
                        "v_cleaner_2"));

        productlist
                .add(new Product(
                        "WE Beretta M92 Long",
                        "Пистолет WE Beretta M92 Long Silver Wood GGBB (GP304)",
                        "Питание: заправка газом.\n" +
                                "Начальная скорость шарика: 95-105 м\\с.\n" +
                                "Емкость магазина: 25 шариков.\n" +
                                "Для стабильной работы рекомендуется хранить магазин полностью заправленным, с грингазом внутри.\n" +
                                "Комплектация: пистолет, инструкция, магазин.\n",
                        "2500",
                        "10",
                        "1000",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/b92/900_600_12f28b1e9c3c5899ab618b8ff44e28632/59088815-799f-11e2-9b43-10bf4871b40e_0bdda47f-6684-11ee-af5d-00505687ed93.jpeg",
                        "v_cleaner_3"));


        productMap.put("Beretta серия", productlist);


        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllFurnitures() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // Table
        productlist
                .add(new Product(
                        "Arcturus AR-15",
                        "Карабин Arcturus AR-15 Rifle 16' (AT-AR01-RF)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 120 м/с\n" +
                                "- длина внутреннего стволика: 430 мм\n" +
                                "- ёмкость бункерного магазина 300 шаров, механического 130 шаров.\n" +
                                "- резьба для глушителя 14-\n" +
                                "- разъём T-type, в комплекте есть переходник на Mini-tamiya\n" +
                                "\n" +
                                "Комплектация – привод, бункерный и механический магазин, складные механические прицельные приспособления.\n",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/c92/900_600_12f28b1e9c3c5899ab618b8ff44e28632/b5869d33-915a-11e8-9447-000c295b5c66_0934d8d5-b97f-11ec-8ded-00505687ed93.jpeg",
                        "table_1"));

        productlist
                .add(new Product(
                        "East Crane M4",
                        "Карабин East Crane M4 CQBR BK (EC-302)",
                        "Корпус привода выполнен из алюминиевого сплава. Ствольная коробка состоит из двух половин: верхнего и нижнего ресиверов, которые соединяются двумя штифтами. К верхнему ресиверу крепятся ствол и цевьё, к нижнему - направляющая приклада и пистолетная рукоятка. Все соединения выполнены плотно и надёжно, люфты полностью отсутствуют. На крышке верхнего ресивера выполнена стандартная планка пикатинни, на которую можно установить практически любой коллиматорный или оптический прицел.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/2e8/900_600_12f28b1e9c3c5899ab618b8ff44e28632/672e62d4-2ba9-11ea-8858-000c295b5c66_3cd2e133-9ae3-11ed-9de5-00505687ed93.jpeg",
                        "table_2"));

        productlist
                .add(new Product(
                        "Tokyo Marui Mk.18",
                        "Карабин Tokyo Marui Mk.18 mod 1 Next Gen AEG (TM4952839176264)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 85-90 м/с\n" +
                                "- длина внутреннего стволика: 280 мм\n" +
                                "- ёмкость магазина 82 шара\n" +
                                "- резьба для глушителя 14-\n" +
                                "\n" +
                                "Комплектация: привод, механический магазин на 82 шара, инструкция, переходник для зарядного устройства и логотип морсека внутри коробки.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/051/900_600_12f28b1e9c3c5899ab618b8ff44e28632/fdfd2297-3026-11e9-b1de-000c295b5c66_79dc9946-70c3-11e9-b1de-000c295b5c66.jpeg",
                        "table_3"));



        productMap.put("М серия", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "LCT АК-74М",
                        "Автомат LCT АК-74М (LCK74MN)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 120 м/с\n" +
                                "- длина внутреннего стволика: 455 мм\n" +
                                "- ёмкость магазина 130 шаров\n" +
                                "- резьба для глушителя М24+\n" +
                                "\n" +
                                "Комплектация: привод, механический магазин на 130 шаров, инструкция.",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/2fc/900_600_12f28b1e9c3c5899ab618b8ff44e28632/460feda3-1dfa-11e2-9cbf-10bf4871b40e_9654d6ed-0bde-11ed-9ccc-00505687ed93.jpeg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Arcturus АК74",
                        "Автомат Arcturus АК74 Custom (AT-AK04)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 115 м/с\n" +
                                "- длина внутреннего стволика: 380 мм\n" +
                                "- ёмкость магазина 320 шаров, механический магазин 130 шаров (может быть переключен на 30)\n" +
                                "- разъём T-type, в комплекте есть переходник на Mini-tamiya\n",
                        "500",
                        "20",
                        "200",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/85f/900_600_12f28b1e9c3c5899ab618b8ff44e28632/82049525-3598-11e9-b1de-000c295b5c66_4eeb9c91-4118-11ec-9caa-00505687ed93.jpeg",
                        "chair_2"));

        productlist
                .add(new Product(
                        "E&L АКСУ",
                        "Автомат E&L АКСУ AEG Essential (EL-A104S)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 105 м/с\n" +
                                "- длина внутреннего стволика: 330 мм\n" +
                                "- ёмкость магазина 300 шаров, механический магазин 130 шаров (может быть переключен на 30)\n" +
                                "- разъём T-type, в комплекте есть переходник на Mini-tamiya\n",
                        "500",
                        "20",
                        "200",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/0cc/900_600_12f28b1e9c3c5899ab618b8ff44e28632/1ae37eae-0be2-11ed-9ccc-00505687ed93_e0f15494-cae6-11ed-b0dc-00505687ed93.jpeg",
                        "chair_3"));





        productMap.put("АК серия", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "Cyma M24",
                        "Снайперская винтовка Cyma M24 spring (CM702B)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 100 м/с\n" +
                                "- длина внутреннего стволика: 490 мм\n" +
                                "- ёмкость магазина 30 шаров\n" +
                                "- резьба для глушителя уникальная\n" +
                                "\n" +
                                "Комплектация: винтовка, механический магазин на 30 шаров, инструкция, лоадер, переходник на резьбу М14-, шомпол.\n" +
                                "\n" +
                                "ВНИМАНИЕ!\n" +
                                "Для установки оптических прицелов под артикулами HY1048, HY1077, HY1119 потребуются высокие кольца.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/31a/900_600_12f28b1e9c3c5899ab618b8ff44e28632/f45c1fc8-e982-11e4-9d72-94de8003c4f2_06a27648-eb77-11e5-a1ad-94de8003c4f2.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "Tokyo Marui L96",
                        "Снайперская винтовка Tokyo Marui L96 AWS spring OD (TM4952839135070)",
                        "Тактико-Технические Характеристики:\n" +
                                "- начальная скорость вылета шара примерно 90 м/с\n" +
                                "- длина внутреннего стволика: 500 мм\n" +
                                "- ёмкость магазина 40 шаров\n" +
                                "- резьба для глушителя уникальная\n" +
                                "\n" +
                                "Комплектация: винтовка, магазин, шомпол, шарики для теста.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/81a/900_600_12f28b1e9c3c5899ab618b8ff44e28632/e8df6bb6-99bc-11e6-b44d-94de8003c4f2_493c4664-c6b7-11e6-aaec-94de8003c4f2.jpeg",
                        "almirah_2"));

        productlist
                .add(new Product(
                        "LCT СВД",
                        "Снайперская винтовка LCT СВД (дерево) (SVD(WOOD))",
                        "Питается от стандартных аккумуляторов Ni-MH, Li-Po, Li-FePO, напряжением от 7.4 вольта до 11.1 вольта.\n" +
                                "Начальная скорость полёта шара примерно 120 м\\с\n" +
                                "Ёмкость магазина 55 шаров\n" +
                                "Разъем для АКБ T-type\n" +
                                "\n" +
                                "Комплектация: винтовка, механический магазин на 55 шаров, инструкция.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://airsoft-rus.ru/upload/resize_cache/iblock/06b/900_600_12f28b1e9c3c5899ab618b8ff44e28632/ff87e9fd-0e31-11ed-9ccc-00505687ed93_339ea4e8-8c18-11ed-9de5-00505687ed93.jpeg",
                        "almirah_3"));



        productMap.put("Винтовки", productlist);



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
