# 📝 Kullanıcı Dostu Görev ve Hatırlatma Yönetim API'si  

Bu proje, kullanıcıların görevlerini yönetmelerine, hatırlatmalar oluşturmalarına ve verimli bir şekilde çalışmalarına yardımcı olmak için geliştirilmiş bir **Spring Boot mikroservis tabanlı görev yönetim API'sidir**.

## 🚀 Proje Özellikleri  
- 🏗 **Spring Boot & PostgreSQL** tabanlı backend  
- 🔐 **JWT Authentication & Spring Security** ile güvenli erişim  
- 📅 **Görev yönetimi** (ekleme, güncelleme, silme, listeleme)  
- ⏰ **Hatırlatıcı bildirimleri** (e-posta & opsiyonel push bildirimleri)  
- 📊 **İstatistik ve analiz özellikleri** (yakında...)  
- ☁ **Mikroservis mimarisi** ile ölçeklenebilir yapı  

## 📦 Kurulum  
1. **Projeyi klonla:**  
   ```bash
   git clone https://github.com/kullaniciadi/projeadi.git
   
Bağımlılıkları yükle:
mvn clean install

Uygulamayı çalıştır:
mvn spring-boot:run

POST /api/users/register → Yeni kullanıcı kaydı
POST /api/tasks/create → Yeni görev oluşturma
GET /api/tasks → Kullanıcının görevlerini listeleme
PUT /api/tasks/update/{id} → Görevi güncelleme
DELETE /api/tasks/delete/{id} → Görevi silme

