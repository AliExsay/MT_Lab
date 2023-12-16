//
//  ContentView.swift
//  lab6
//
//  Created by AliExsay on 30.11.2023.
//

import SwiftUI

struct ContentView: View {
    
    @State private var selectedView = 1
    
    var body: some View {
        TabView(selection: $selectedView)  {
            PhotoView()
                .tabItem {
                    Image(systemName: "photo")
                    Text("фото")
                } .tag(1)
            VideoView()
                .tabItem {
                    Image(systemName: "camera")
                    Text("видео")
                } .tag(2)
            MusicPlayer()
                .tabItem {
                    Image(systemName: "play")
                    Text("аудио")
                } .tag(3)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
