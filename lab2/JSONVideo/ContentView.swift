
import SwiftUI

struct ContentView: View {
    
    @State var posts: [Post] = []
    @State var comment: [Comments] = []
    @State private var selectedView = 1
    
    var body: some View {
        TabView(selection: $selectedView) {
            NavigationView {
                
                List(posts) { post in
                    NavigationLink(destination: PostView(post: post)) {
                        Button(action: {
                            PostView(post: post)
                        }) {
                            Text(post.title)
                                .fontWeight(.bold)
                                .foregroundColor(.black)
                        }
                    }
                }
                .navigationBarTitle("Posts")
                .navigationBarItems(trailing: Button(action: {
                    Api().getPost { (posts) in
                        self.posts = posts
                    }
                }){
                    Text("load")
                })
                
            }
            .tabItem {
                Image(systemName: "1.circle.fill")
                Text("Сай")
            } .tag(1)
                .imageScale(.medium)
            
            
            
            
            NavigationView {
                
                List(comment) { com in
                    NavigationLink(destination: CommentsView(comment: com)) {
                        Button(action: {
                            CommentsView(comment: com)
                        }) {
                            Text(com.name)
                                .fontWeight(.bold)
                                .foregroundColor(.black)
                        }
                    }
                }
                .navigationBarTitle("Comment")
                .navigationBarItems(trailing: Button(action: {
                    ApiComments().getPost { (comment) in
                        self.comment = comment
                    }
                }){
                    Text("load")
                })
            }
            
            .tabItem {
                Image(systemName: "2.circle.fill")
                Text("Олег")
            } .tag(2)
        }
    }
}

struct PostView: View {
    var post: Post
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text("User ID: ")
                    .fontWeight(.bold)
                Text(String(post.userId))
            }
            HStack {
                Text("Title: ")
                    .fontWeight(.bold)
                Text(post.title)
            }
            HStack {
                Text("Body: ")
                    .fontWeight(.bold)
                Text(String(post.body))
            }
//            Text("Title: \(post.title)")
//            Text("body: \(post.body)")
        }
    }
}

struct CommentsView: View {
    var comment: Comments
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text("Post iD: ")
                    .fontWeight(.bold)
                Text(String(comment.postId))
            }
            HStack {
                Text("Name: ")
                    .fontWeight(.bold)
                Text(comment.name)
            }
            HStack {
                Text("Email: ")
                    .fontWeight(.bold)
                Text(comment.email)
            }
            HStack {
                Text("Body: ")
                    .fontWeight(.bold)
                Text(comment.body)
            }
        }
    }
}

struct Post: Codable, Identifiable {
    let id = UUID()
    var title: String
    var body: String
    var userId: Int
    //        var massageId: Int
}

class Api {
    func getPost(completion: @escaping ([Post]) -> ()) {
        guard let url = URL(string: "https://jsonplaceholder.typicode.com/posts") else { return }
        
        URLSession.shared.dataTask(with: url) { (data, _, _) in
            let posts = try! JSONDecoder().decode([Post].self, from: data!)
            DispatchQueue.main.async {
                completion(posts)
            }
        }
        .resume()
    }
}


struct Comments: Codable, Identifiable {
    let id = UUID()
    var name: String
    var body: String
    var email: String
    var postId: Int
}

class ApiComments {
    func getPost(completion: @escaping ([Comments]) -> ()) {
        guard let url = URL(string: "https://jsonplaceholder.typicode.com/comments") else { return }
        
        URLSession.shared.dataTask(with: url) { (data, _, _) in
            let commentss = try! JSONDecoder().decode([Comments].self, from: data!)
            DispatchQueue.main.async {
                completion(commentss)
            }
        }
        .resume()
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
