**Szoftver követelmény specifikáció a kemping recepciós szoftverhez**

A fejlesztés célja egy vizuálisan részletes, és átlátható web alkalmazás készítése, amely
képes nyílvántartani egy kemping foglalásait, és megjeleníteni parcelláinak állapotát.
Az alkalmazást a kemping recepciósa kezeli.

A recepciós felhasználói felülete egy térkép a kempingről, amelyen táblázat szerűen vannak jelölve kemping
különböző parcellái. A táblázat cellái egy-egy kiadható kemping helyet jelölnek. A cellákat egy, vagy több éjszakára
lehet lefoglalni. A foglalás két féle típusú lehet, sátras vagy lakókocsis. Minden parcellához kérhető áram csatlakozás.
A cellák színezése a parcella állapotától függ:
* Zöld - a cella nincs lefoglalva egy éjszakára sem az adott intervallumon belül.
* Szürke - a cella legalább egy éjszakára le van foglalva az adott intervallumon belül.

Navigációs menü:
* Kezdőlap: térkép + idő-intervallum beállítás
* Foglalás: űrlap egy cella lefoglalásához
* Foglalások: táblázat a jelenleg rendszerben lévő foglalásokkal

A cellára kattintva megjelenik az adott cella információt tartalmazó ablak:
* Cella azonosító: number
* Állapot: bool (használatban, nem használatban)
* Táblázat: 
    * Érkezés: date
    * Távozás: date
    * Vezetéknév: string
    * Keresztnév: string
    * Áram: bool
    * Típus: number -> string (Sátor, Lakókocsi)
    * Foglalás törlése gomb
    * Számla kiállítása gomb
* Foglalás felvétel: gomb
    * Felhozza a hely foglalása form-ot (lejjebb részletesen),
     a parcella azonosítója mezőt automatikusan kitöltve.

A recepciós a navigációs menüben lévő "Foglalás" gomb megnyomásával előhozza a hely
foglalása form-ot, ahova a foglalás részleteit kell beírni.
Foglalás form:
* Cella azonosító: number
* Érkezés: date
* Távozás date
* Vezetéknév: string
* Keresztnév: string
* Telefonszám: string
* Típus: drop down (Sátor(0), Lakókocsi(1)) number
* Áram: bool
* Elfogadás, és bezárás gomb

Ha az adatok nem megfelelőek, vagy az adott idő-intervallumon belül már foglalt a cella,
az oldal hibaüzenetet dob és nem menti el a foglalást.

Foglalások menüpont:

Megjelenik egy táblázat az összes rendszerben lévő foglalás adataival. A sorok végén "Módosítás", 
"Törlés", és "Számla" lehetőséggel.
* Érkezés: date
* Távozás: date
* Vezetéknév: string
* Keresztnév: string
* Áram: bool
* Típus: number -> string (Sátor, Lakókocsi)

Módosítás form: Automatikusan kitölti a mezőket a módosítandó foglalás adataival. Az mezők alatt
két gomb van: "Mentés" és "Mégsem"

Számla kiállítás:

Számla kiállítást az adott foglaláshoz a "Foglalások" menüpontban, vagy a cella információk ablakból
lehet indítani.
A számla tartalma:
* Érkezés: date
* Távozás: date
* Vezetéknév: string
* Keresztnév: string
* Tételek:
    * Napok száma: number
    * Típus: number -> string
    * Áram: bool
    * Végösszeg: number
