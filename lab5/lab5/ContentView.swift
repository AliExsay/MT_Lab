//
//  ContentView.swift
//  lab5
//
//  Created by AliExsay on 01.12.2023.
//

import SwiftUI
import PDFKit

struct ContentView: View {
    
    @State private var selectedView = 1
    @State var urlString = ["1", "2", "3", "5", "7"]
    
    let url = ("https://ntv.ifmo.ru/file/journal/1.pdf")
    
    let url1 = Bundle.main.url(forResource: "1", withExtension: "pdf")!
    let url2 = Bundle.main.url(forResource: "2", withExtension: "pdf")!
    let url3 = Bundle.main.url(forResource: "3", withExtension: "pdf")!
    let url5 = Bundle.main.url(forResource: "5", withExtension: "pdf")!
    let url7 = Bundle.main.url(forResource: "7", withExtension: "pdf")!
    @State private var numberPDF = "2"
    @State private var show = false
    
    
    var body: some View {
        TabView(selection: $selectedView)  {
            VStack {
                Text("Подготовил Сай Олег")
                HStack {
                    Button(action: {
                        self.show.toggle()
                        sleep(2)
                        printPDF()
//                        PDFKitRepresentedView(documentURL: url1)
                    }) {
                        Text("загрузить")
                    }
                    
                    Button(action: {
                        self.show.toggle()
                    }) {
                        Text("удалить")
                    }
                }
//                PDFKitRepresentedView(documentURL: url1)
                if show {
                    if numberPDF == "1" {
                        PDFKitRepresentedView(documentURL: url1)
                    } else if numberPDF == "2" {
                        PDFKitRepresentedView(documentURL: url2)
                    } else if numberPDF == "3" {
                        PDFKitRepresentedView(documentURL: url3)
                    } else if numberPDF == "5" {
                        PDFKitRepresentedView(documentURL: url5)
                    } else if numberPDF == "7" {
                        PDFKitRepresentedView(documentURL: url7)
                    } else {
                        PDFKitRepresentedView(documentURL: url2)
                    }
                }

            }
                .tabItem {
                    Text("First")
                } .tag(1)
            
            VStack {
                Text("выберите номер файла")
                TextField("введите номер статьи", text: $numberPDF)
            }
                .tabItem {
                    Text("Second")
                } .tag(2)
        }
        
        .padding()
    }
    
    func printPDF() {
        switch numberPDF {
        case "1":
            PDFKitRepresentedView(documentURL: url1)
        case "3":
            PDFKitRepresentedView(documentURL: url3)
        case "5":
            PDFKitRepresentedView(documentURL: url5)
        case "7":
            PDFKitRepresentedView(documentURL: url7)
        default:
            PDFKitRepresentedView(documentURL: url2)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
