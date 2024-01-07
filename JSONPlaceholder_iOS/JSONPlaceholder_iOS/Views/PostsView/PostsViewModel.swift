//
//  PostsViewModel.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import SwiftUI

class PostsViewModel: ObservableObject {
    @Published var posts = [PostModel]()
    
    func loadPosts() {
        ApiRepository.shared.getPosts { posts, error in
            if (posts == nil || posts?.isEmpty == true) {
                print("No Posts")
            } else {
                self.posts = posts!
            }
        }
    }
}
