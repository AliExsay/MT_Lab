//
//  ImagePicker.swift
//  lab6
//
//  Created by AliExsay on 30.11.2023.
//

import SwiftUI
//import PhotosUI

struct ImagePicker: UIViewControllerRepresentable {
    
    @Binding var image: UIImage
    
    func makeUIViewController(context: Context) -> some UIViewController {
        let imagePicker = UIImagePickerController()
        imagePicker.allowsEditing = true
        imagePicker.sourceType = .photoLibrary
        imagePicker.delegate = context.coordinator
        return imagePicker
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) { }
    
    func makeCoordinator() -> Coordinator {
        Coordinator(parent: self)
    }
    
    final class Coordinator: NSObject, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
        var parent: ImagePicker
        
        init(parent: ImagePicker) {
            self.parent = parent
        }
        
        func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
            if let selectImage = info[.editedImage] as? UIImage {
                self.parent.image = selectImage
            }
            
            picker.dismiss(animated: true)
        }
        
    }
    
}
