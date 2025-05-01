# 📝 Kullanıcı Dostu Görev ve Hatırlatma Yönetim API'si  

Bu proje, kullanıcıların görevlerini yönetmelerine, hatırlatmalar oluşturmalarına ve verimli bir şekilde çalışmalarına yardımcı olmak için geliştirilmiş bir **Spring Boot mikroservis tabanlı görev yönetim API'sidir**.

## 🚀 Proje Özellikleri  
- 🏗 **Spring Boot & PostgreSQL** tabanlı backend  
- 🔐 **JWT Authentication & Spring Security** ile güvenli erişim  (Geliştirmeye açık)
- 📅 **Görev yönetimi** (ekleme, güncelleme, silme, listeleme)  
- ⏰ **Hatırlatıcı bildirimleri** (e-posta & opsiyonel push bildirimleri)  
- ☁ **Mikroservis mimarisi** ile ölçeklenebilir yapı

- Proje Özeti
Bu API, bir görev yönetim sistemi sağlar. Kullanıcılar, görevlerini sisteme kaydedebilir, görevleri kategorilere ayırabilir ve görevler için bir tamamlanma durumu belirleyebilir. Görevlerin bitiş tarihleri geldiğinde, kullanıcıya hatırlatma e-postası gönderilir.

Teknolojiler
Java 17: Uygulama dili.
Lombok : Getter , Setter ,Constructor için kısa yol 
Spring Boot: API geliştirme framework'ü.
H2 Database: Geliştirme ve test amacıyla kullanılan hafif veritabanı.
Spring Data JPA: Veritabanı işlemleri için ORM kullanımı.
JavaMailSender: E-posta gönderimi için kullanılan araç.
postman ve swagger : test etmek için


Kullanıcı API'leri
POST /api/users/create: Yeni kullanıcı oluşturur.

GET /api/users/list: Tüm kullanıcıları listeler.

GET /api/users/{id}: ID'ye göre bir kullanıcıyı getirir.

PUT /api/users/update/{id}: Kullanıcıyı günceller.

DELETE /api/users/delete/{id}: Kullanıcıyı siler.



Görev API'leri
POST /api/tasks/create: Yeni bir görev oluşturur.

GET /api/tasks/list: Tüm görevleri listeler.

GET /api/tasks/{id}: ID'ye göre bir görevi getirir.

PUT /api/tasks/update/{id}: Görevi günceller.

DELETE /api/tasks/delete/{id}: Görevi siler.


E-posta Gönderimi
Her görevin bitiş tarihi geldiğinde, kullanıcıya hatırlatıcı bir e-posta gönderilir. Bu özellik, JavaMailSender kullanılarak gerçekleştirilmiştir.


Projenin frontend kısmı için https://github.com/Sosun044/taskmanager-frontend adresli repoya göz atmanızı rica ederim.
