// Espera o carregamento completo da página antes de executar o script
window.onload = function() {
    // Obtém a imagem principal
    var mainImage = document.getElementById('mainImage');
    
    // Obtém todas as miniaturas
    var thumbnails = document.querySelectorAll('.thumbnail');
    
    // Adiciona um evento de clique a cada miniatura
    thumbnails.forEach(function(thumbnail) {
        thumbnail.addEventListener('click', function() {
            // Ao clicar, troca o src da imagem principal para o src da miniatura clicada
            mainImage.src = thumbnail.src;
        });
    });
};