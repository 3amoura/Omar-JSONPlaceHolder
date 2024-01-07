//
//  ApiRepository.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import Foundation

class ApiRepository {
    
    static let shared = ApiRepository()
    let apiManager = ApiManager()
    
    private init() {
        
    }
    
    func getPosts(onCompletion: @escaping ([PostModel]?, Error?) -> Void) {
        do {
            apiManager.getPosts().done { properties in
                onCompletion(properties, nil)
            }.catch { error in
                
                onCompletion(nil, error)
            }
        }
    }
}
