//
//  JSONPlaceholder_iOSApp.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import SwiftUI

@main
struct JSONPlaceholder_iOSApp: App {
    var body: some Scene {
        WindowGroup {
            PostsView().environmentObject(PostsViewModel())
        }
    }
}
