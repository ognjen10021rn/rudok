#### [**Funkcionalnosti**](#funkcionalnosti) | [**Dizajn Paterni**](#dizajn-paterni) | [**Tehnologije**](#tehnologije) | [**Instalacija i Pokretanje**](#instalacija-i-pokretanje)
<div align="center"><h1>Dobrodošli u RuDok!</h1></div>
<div align="center">
  <b>RuDok</b> je desktop aplikacija napravljena u Javi, razvijena kao klon PowerPoint-a. Projekat je prvenstveno korišćen za učenje i implementaciju raznih dizajn paterna u objektno-orijentisanom programiranju (OOP). Cilj projekta je bio da studenti steknu iskustvo u kreiranju složenijih aplikacija kroz pravilnu primenu principa softverskog dizajna.
</div>
<br>

<div align="center"><img src="https://github.com/user-attachments/assets/66d1752e-5cb2-4b92-a222-d2f8a068b962" alt="Opis slike" width="70%"/></div>

## Funkcionalnosti
- Kreiranje i uređivanje dokumenata, stranica i slajdova
- Struktura koja podržava hijerarhijsko upravljanje sadržajem
- Omogućava dodavanje, uklanjanje i pomeranje elemenata unutar prezentacije
- Prikazivanje prezentacija sa osnovnim navigacionim opcijama
- Serijalizacija i deserializacija podataka, uključujući:
  - Ceo workspace
  - Projekat sa njegovim prezentacijama
  - Prezentacije sa slajdovima

## Dizajn Paterni
U ovom projektu implementirani su sledeći dizajn paterni:
- **Prosireni MVC (Model-View-Controller)** sa **Publisher-Subscriber** modelom: Korišćen za organizaciju aplikacije i omogućavanje komunikacije između različitih komponenti kroz objavljivanje i pretplatu na događaje.
- **Observer**: Praćenje i osvežavanje korisničkog interfejsa pri promenama u podacima.
- **Composite**: Hijerarhijska struktura za rad sa slajdovima, prezentacijama i projektima.
- **Command**: Implementacija akcija sa podrškom za "Undo" i "Redo" funkcionalnosti.
- **State**: Korišćen za upravljanje različitim stanjima aplikacije, kao što su uređivanje, prikazivanje i menjanje slajdova.
- **Action**: Model za definisanje akcija koje korisnik može preduzeti, što omogućava lako upravljanje različitim funkcionalnostima.
- **Tree Structure**: Rad sa stablastom strukturom podataka za organizaciju projekata, prezentacija i slajdova.
- **Serialization**: Omogućava čuvanje i učitavanje workspace-a, projekata i prezentacija sa slajdovima.

## Tehnologije
- **Java**
- **Swing** (za GUI)
- **JavaFX** (za napredne grafičke efekte)

## Instalacija i Pokretanje
1. Klonirajte repozitorijum:
   ```bash
   git clone https://github.com/ognjen10021rn/rudok-ognjen-stojanovic.git
2. Otvorite projekat u vašem preferiranom code editoru.
3. Pokrenite fajl pod imenom ``Main.java``

Autor: Ognjen Stojanović
