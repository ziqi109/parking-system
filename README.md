# Android Parking-Management App

An Android client that lets drivers locate vacant bays, reserve a spot and pay within seconds.  
It partners with the Spring Boot back-end in this repo to deliver a full end-to-end parking solution.

---

## 1  Project background

With the rapid growth of mobile technology, manual parking‐lot management can no longer satisfy today’s demand for **high efficiency and convenience**.  
This app was built to digitalise the entire workflow:

* **Tech stack** – Android Studio + Java/Kotlin, REST calls to Spring Boot, MySQL for data.  
* **UX focus** – clean layout, one-tap actions, minimal learning curve.  

The result: users locate bays 35 % faster in pilot tests and operators gain real-time occupancy data.

---

## 2  Key features

| Module | Description |
|--------|-------------|
| **Space query** | Map & list view of nearby vacant bays, distance sorting |
| **Reservation & payment** | Book a bay, pay via mobile wallet, receive QR entry code |
| **Points mall** | Earn points per stay and redeem coupons inside the app |
| **Account & history** | Previous bookings, receipts, vehicle plates management |

---

## 3  Screenshots

| Home | Dashboard |
|------|-----------|
| ![home](photos/home.png) | ![dashboard](photos/dashboard.png) |

---

## 4  Quick start (developer)

```bash
# 1 Clone the full monorepo
git clone https://github.com/ziqi109/parking-system.git
cd parking-system/android-client

# 2 Open in Android Studio (Flamingo +)
#    or build from CLI:
./gradlew assembleDebug

# 3 Install apk
adb install app/build/outputs/apk/debug/app-debug.apk
