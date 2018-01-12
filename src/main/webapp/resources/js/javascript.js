//KORISNIK
function makniProizvodIzKosarice(btn)
{
    var id = btn.id.substr(8);
    var kolicina = document.getElementById("numKolicina" + id).value;
    window.location.href = "/WebShop/Kosarica?id=" + id + "&akcija=" + 2 + "&kolicina=" + kolicina;
}

function povecajBrojProizvodaUKosarici(btn)
{
    var id = btn.id.substr(8);
    var kolicina = document.getElementById("numKolicina" + id).value;
    window.location.href = "/WebShop/Kosarica?id=" + id + "&akcija=" + 1 + "&kolicina=" + kolicina;
}

function dovrsiPlacanje(btn)
{
    window.location.href = "/WebShop/AuthKorisnik/OdabirPlacanja.jsp";
}

function dodajProizvodUKosaricu() {
    var id = document.getElementById("proizvodId").textContent;
    var kolicina = document.getElementById("numKolicina").value;
    window.location.href = "/WebShop/Kosarica?id=" + id + "&akcija=" + 1 + "&kolicina=" + kolicina;
}

function displayProizvodKorisnik(id) {
    proizvodId = id.toString().split("_")[1];
    $.ajax({url: "/WebShop/DetaljiProizvoda?id=" + proizvodId,
        success: function (data) {
            document.getElementById("proizvodNaziv").textContent = data.naziv;
            document.getElementById("proizvodKategorija").textContent = data.kategorija;
            document.getElementById("proizvodCijena").textContent = getCijenaKune(data.cijena);
            document.getElementById("proizvodSlika").src = data.slika;
            document.getElementById("proizvodOpis").textContent = data.opis;
            document.getElementById("proizvodId").textContent = data.proizvodId;
            document.getElementById("divDetails").classList.remove("hidden");
        }
    });
}

function getCijenaKune(cijena) {
    return cijena.toFixed(2) + " KN";
}

//ADMIN
function prikaziPristupeKorisnika(kolicina) {
    window.location.href = "/WebShop/PristupStranicama?kolicinaZapisa=" + kolicina;
}

function displayProizvodAdmin(id) {
    $.ajax({url: "/WebShop/DetaljiProizvoda?id=" + id,
        success: function (data) {
            document.getElementById("proizvodNaziv").value = data.naziv;
            document.getElementById("proizvodCijena").value = data.cijena;
            document.getElementById("proizvodSlika").value = data.slika;
            document.getElementById("proizvodOpis").value = data.opis;
            document.getElementById("proizvodId").value = data.proizvodId;
            document.getElementById("btnPromjena").classList.remove("hidden");
        }
    });
}
