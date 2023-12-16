//
//  PhotoView.swift
//  lab6
//
//  Created by AliExsay on 30.11.2023.
//

import SwiftUI

struct PhotoView: View {
    @State var image = UIImage(named: "1.png")!
    @State var isPickerShow = false
    
    
    var body: some View {
        VStack {
            Text("Подготовил Сай Олег")
            ZStack(alignment: Alignment(horizontal: .trailing, vertical: .bottom)) {
                Image(uiImage: image)
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                    .frame(width: 300, height: 300)
                    .clipped()
                    .cornerRadius(20)
                
                Button(action: {
                    isPickerShow.toggle()
                }) {
                    ZStack {
                        Circle()
                            .frame(width: 50, height: 50)
                            .foregroundColor(.pink)
                            .overlay(RoundedRectangle(cornerRadius: 25) .stroke(Color.white, lineWidth: 3))
                        Image(systemName: "camera.fill")
                            .foregroundColor(.white)
                    }
                } .offset(x: 20, y: 20)
                    .sheet(isPresented: $isPickerShow) {
                        ImagePicker(image: $image)
                    }
            }
        }
    }
}

struct PhotoView_Previews: PreviewProvider {
    static var previews: some View {
        PhotoView()
    }
}
