const cards = {
    ambientes: [
        {
            title: "BEACH TENNIS | VÔLEI DE AREIA",
            image: "https://via.placeholder.com/300x200",
            description: "Quadra de areia com rede e suporte para jogar Beach Tennis e Vôlei de Areia"
        },
        {
            title: "FUTEBOL | RUGBY",
            image: "https://via.placeholder.com/300x200",
            description: "Campo gramado disponível para partidas de Futebol e Rugby"
        },
        {
            title: "FUTSAL | VÔLEI | BASQUETE",
            image: "https://via.placeholder.com/300x200",
            description: "Ginásio coberto para Futsal, Vôlei e Basquete"
        }
    ],
    aulas: [
        {
            title: "AULA DE YOGA",
            image: "https://via.placeholder.com/300x200",
            description: "Aulas de Yoga em ambiente aberto, apropriado para relaxamento e concentração."
        },
        {
            title: "AULA DE PILATES",
            image: "https://via.placeholder.com/300x200",
            description: "Pilates em grupo com instrutores certificados."
        },
        {
            title: "AULA DE CROSSFIT",
            image: "https://via.placeholder.com/300x200",
            description: "Treinos intensos de Crossfit ao ar livre."
        }
    ],
    acessorios: [
        {
            title: "RAQUETE DE BEACH TENNIS",
            image: "https://via.placeholder.com/300x200",
            description: "Raquete profisnômico."
        },
        {
            title: "BOLA DE FUTEBOL",
            image: "https://via.placeholder.com/300x200",
            description: "Bola de futebol oficial de alta qualidade."
        },
        {
            title: "TÊNIS PARA FUTSAL",
            image: "https://via.placeholder.com/300x200",
            description: "Tênis com aderência e conforto para praticantes de futsal."
        }
    ]
};

function showCards(category) {
    // Atualiza os botões ativos
    document.querySelectorAll('.options-bar button').forEach(button => {
        button.classList.remove('active');
    });
    document.getElementById(`btn-${category}`).classList.add('active');

    // Atualiza os cards
    const container = document.getElementById('cards-container');
    container.innerHTML = ''; // Limpa os cards anteriores
    cards[category].forEach(card => {
        container.innerHTML += `
            <div class="card">
                <img src="${card.image}" alt="${card.title}">
                <h3>${card.title}</h3>
                <p>${card.description}</p>
                <button>Agende Aqui</button>
            </div>
        `;
    });
}

// Mostra os cards de ambientes por padrão ao carregar a página
showCards('ambientes');