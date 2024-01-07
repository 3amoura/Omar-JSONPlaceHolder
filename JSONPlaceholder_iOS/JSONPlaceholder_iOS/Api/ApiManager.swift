//
//  ApiManager.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import Foundation
import PromiseKit
import Alamofire

class ApiManager {
    func getPosts() -> Promise<[PostModel]> {
        return Promise() { resolver in
            var request =  try URLRequest(url: URL(string: "https://jsonplaceholder.typicode.com/posts/")!, method: .get)
            request.httpMethod = HTTPMethod.get.rawValue
            
            AF.request(request)
                .responseData { response in
                    switch response.result {
                    case .success:
                        do {
                            let reponseJSON = try JSONDecoder().decode([PostModel].self, from: response.data!)
                            resolver.fulfill(reponseJSON)
                        } catch (let error) {
                            resolver.reject(error)
                        }
                    case .failure(let error):
                        resolver.reject(error)
                    }
                }
        }
    }
}
