package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
<게시판서비스>
1.계좌객체 : Author, Post
2.자료구조 : List(authorList, postList)
3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
 3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
 3-2.회원 전체 목록 조회 : id, email
 3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
 3-4.게시글 작성 : id, title, contents, 작성자Email(직접 Author 객체를 변수로 갖는것도 가능)
 3-5.게시물 목록 조회 : id(post), title
 3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름
*/
public class C10BoardService {
    public static void main(String[] args) {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("사용하실 서비스 번호를 입력해주세요.");
            int number = Integer.parseInt(sc.nextLine());
            if(number==1){
                System.out.println("회원가입 서비스입니다. 이름, 이메일, 비밀번호를 입력해주세요.");
                String name = sc.nextLine();
                String email = sc.nextLine();
                String password = sc.nextLine();
                Author a = new Author(name,email,password);
                authorList.add(a);

            }
            else if(number==2){
                System.out.println("회원목록 조회서비스입니다.");
                for(Author a : authorList){
                    System.out.println(a.getId());
                    System.out.println(a.getEmail());
                }
            }
            else if(number==3){
                System.out.println("회원상세조회 서비스 입니다.");
                System.out.println("회원ID를 입력해주세요.");
                long id = Long.parseLong(sc.nextLine());
                Author author = null;
                for(Author a : authorList){
                    if(a.getId()==id){
                        author = a;
                        break;
                    }
                }
//                long count = 0;
//                for(Post p : postList){
//                    if(p.getEmail().equals(author.getEmail())){
//                        count++;
//                    }
//                }

                System.out.println("id: "+author.getId()+"email: "+author.getEmail()+"name: "+author.getName()+"password: "+author.getPassword()+"작성글수: "+author.getPostList().size());


            }
            else if(number==4){
                System.out.println("게시글 작성서비스 입니다.");
                System.out.println("제목을 입력하세요.");
                String title = sc.nextLine();
                System.out.println("내용을 입력하세요.");
                String contents = sc.nextLine();
                System.out.println("작성자 email을 입력하세요.");
                String email = sc.nextLine();
                Author author = null;
                for(Author a : authorList){
                    if(a.getEmail().equals(email)){
                        author = a;
                        break;
                    }
                }
                Post p = new Post(title,contents,author);
                postList.add(p);

            }
            else if(number==5){
                System.out.println("게시글 목록조회서비스 입니다.");
                for(Post p : postList){
                    System.out.println(p.getId());
                    System.out.println(p.getTitle());
                }
            }
            else if(number==6){
                System.out.println("게시글 상세 조회서비스 입니다.");
                System.out.println("게시글 id를 입력해주세요");
                long id = Long.parseLong(sc.nextLine());
                Post post = null;
                for(Post p : postList){
                    if(p.getId()==id){
                        post = p;
                        break;
                    }
                }
//                Author author = null;
//                for(Author a : authorList){
//                    if(post.getEmail().equals(a.getEmail())){
//                        author = a;
//                        break;
//                    }
//                }
                System.out.println("게시글 ID: "+ post.getId()+"제목:"+post.getTitle()+"내용: "+post.getContents()+ "작성자 이름: "+post.getAuthor().getName());

            }
        }
    }
}
class Author{
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post> postList;
    private static long staticId;

    public Author(String name, String email, String password){
        staticId++;
        this.id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = new ArrayList<>();

    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPostList(){
        return postList;
    }

}
class Post{
    private Long id;
    private String title;
    private String contents;
//    private String email;
    private Author author;
    private static long staticId;

    public Post(String title, String contents, Author author){
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.author = author;
        author.getPostList().add(this);
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }
}