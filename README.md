# LoKaTranslate
A translator by Long and Khanh, Binh Nhon
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This is a VietNamese-English and English-VietNamese Dictionary Application opensources written by Java and JavaFX, this application also using Google Translate API TTS(Text to Speech) to helps user can pronunc the word.
This project is a excercise of my OOP study object.
	
## Technologies
Project is created with:
* JavaFX SDK version: 11.0.2 - https://gluonhq.com/download/javafx-11-0-2-sdk-windows/
	
## Setup
To run this project, dowload the all the repository it locally using IntelliJ IDEA:
1. Dowload the above JavaFX SDK and see this link: https://www.jetbrains.com/help/idea/javafx.html#troubleshoot to see How to add JavaFX library into your IntelliJ IDEA.
2. Go to File -> Project Structure. Select Libraries then Click the Add(+) icon and add this 2 libraries: gtranslateapi-1.0.jar and jl1.0.jar.
3. Extract 2 data base .txt file in the zip to get 2 the English-VietNamese, VietNamese-English Dictionnary database for the application.
Note: All the images is stored in file [image] So you will need to change the link to the image which the codes need to execute without error. For example:
### Code Examples
Fix the link to the image: `BackgroundImage bgi1 = new BackgroundImage(new Image("intro.png")` -> `BackgroundImage bgi1 = new BackgroundImage(new Image("LoKaTranslate-master\image\intro.png")`.
# VietNamese Below:
# LoKaTranslate
Ứng dụng từ điển điện tử by Long Khánh và Bình
## Table of contents
* [Thông tin_Chung](#general-info)
* [Công nghệ](#technologies)
* [Cài đặt](#setup)

## General info
Đây là dự án bài tập lớn trong môn học OOP ĐH Công nghệ-Uet.
	
## Technologies
Ứng dụng sử dụng thư viện giao diện đồ họa JavaFX phiên bản LTS 11 trở lên:
* JavaFX SDK version: 11.0.2 - https://gluonhq.com/download/javafx-11-0-2-sdk-windows/
	
## Setup
Để có thể chạy được ứng dụng trước tiên bạn cần có IDE IntelliJ IDEA. Sau đó thực hiện các thao tác sau:
1. Tải xuống JavaFx trên sau đó xem link hướng dẫn: https://www.jetbrains.com/help/idea/javafx.html#troubleshoot để có thể thêm thư viện giao diện đồ họa thành công cho IntelliJ IDEA.
2. Chuột trái vào File -> Project Structure. Chọn Libraries sau đó nhấn nút Add(+) và thêm 2 thư viện API của Google translate TTS vào: gtranslateapi-1.0.jar and jl1.0.jar.
3. Giải nén 2 file dữ liệu từ điện có đuôi .txt để lấy dữ liệu từ điển anh-việt và việt-anh.
Note: Tất cả ảnh mà ứng dụng cần dùng ở trong file [image] Bạn cần phải đặt đúng đường dẫn đến ảnh mà những dòng code gọi đến để chạy thành công. Ví dụ:
### Code Examples
Sửa lại đường dẫn mặc định trong code sau: `BackgroundImage bgi1 = new BackgroundImage(new Image("intro.png")` thành -> `BackgroundImage bgi1 = new BackgroundImage(new Image("LoKaTranslate-master\image\intro.png")`.
