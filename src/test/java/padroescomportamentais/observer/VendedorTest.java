package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendedorTest {

    @Test
    void deveNotificarUmVendedor() {
        Almoxarifado almoxarifado = new Almoxarifado(202109, 8, "Livro - Divina Comédia", "Capa dura");
        Vendedor vendedor = new Vendedor("Richard Pryor", 92430923, "Renato Aragão");
        vendedor.vender(almoxarifado);
        almoxarifado.atualizarEstoque();
        assertEquals("Richard Pryor, vendeu o produto Almoxarifado{lote=202109, quantidade=8, nome_produto='Livro - Divina Comédia', modelo='Capa dura'}", vendedor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVendedores() {
        Almoxarifado almoxarifado = new Almoxarifado(2222321, 230, "Duff beer", "Lata");
        Vendedor vendedor1 = new Vendedor("Moe Szyslak", 98132152, "Moe Szyslak");
        Vendedor vendedor2 = new Vendedor("Luizinho Capelão", 87693842, "Esposa do Capelão");
        vendedor1.vender(almoxarifado);
        vendedor2.vender(almoxarifado);
        almoxarifado.atualizarEstoque();
        assertEquals("Moe Szyslak, vendeu o produto Almoxarifado{lote=2222321, quantidade=230, nome_produto='Duff beer', modelo='Lata'}", vendedor1.getUltimaNotificacao());
        assertEquals("Luizinho Capelão, vendeu o produto Almoxarifado{lote=2222321, quantidade=230, nome_produto='Duff beer', modelo='Lata'}", vendedor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarVendedor() {
        Almoxarifado almoxarifado = new Almoxarifado(-12321421, 542121321, "Arvores", "Pré-Históricas");
        Vendedor vendedor = new Vendedor("Dino Silvassauro", 923132152, "Richfield");
        almoxarifado.atualizarEstoque();
        assertEquals(null, vendedor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVendedorSupervisor1() {
        Almoxarifado almoxarifadoA = new Almoxarifado(2022, 27, "Picanha", "Seara");
        Almoxarifado almoxarifadoB = new Almoxarifado(2022, 27, "Picanha", "Friboi");
        Vendedor vendedor1 = new Vendedor("Zé Ramalho", 78263124, "Alceu Valença");
        Vendedor vendedor2 = new Vendedor("Fagner", 92341234, "Elba Ramalho");
        vendedor1.vender(almoxarifadoA);
        vendedor2.vender(almoxarifadoB);
        almoxarifadoA.atualizarEstoque();
        assertEquals("Zé Ramalho, vendeu o produto Almoxarifado{lote=2022, quantidade=27, nome_produto='Picanha', modelo='Seara'}", vendedor1.getUltimaNotificacao());
        assertEquals(null, vendedor2.getUltimaNotificacao());
    }
}