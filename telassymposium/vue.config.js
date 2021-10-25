module.exports= {
    pages: {
        'cadastro-edicao-evento': {
            entry: './src/views/cadastro-edicao-evento/main.js',
            template: 'public/index.html',
            title: 'Cadastro/Edicao de evento',
            chunks: ['chunk-vendors', 'chunck-common', 'cadastro-edicao-evento']
        },
        'cadastro-participante': {
            entry: './src/views/cadastro-participante/main.js',
            template: 'public/index.html',
            title: 'Cadastro de participante',
            chunks: ['chunk-vendors', 'chunck-common', 'cadastro-participante']
        },
        'edicao-organizador': {
            entry: './src/views/edicao-organizador/main.js',
            template: 'public/index.html',
            title: 'Edicao de organizador',
            chunks: ['chunk-vendors', 'chunck-common', 'edicao-organizador']
        },
        'edicao-participante': {
            entry: './src/views/edicao-participante/main.js',
            template: 'public/index.html',
            title: 'Edicao de participante',
            chunks: ['chunk-vendors', 'chunck-common', 'edicao-participante']
        },
        'edicao-participante-por-organizador': {
            entry: './src/views/edicao-participante-por-organizador/main.js',
            template: 'public/index.html',
            title: 'Edicao de participante por organizador',
            chunks: ['chunk-vendors', 'chunck-common', 'edicao-participante-por-organizador']
        },
        'evento-inscritos-participante': {
            entry: './src/views/evento-inscritos-participante/main.js',
            template: 'public/index.html',
            title: 'Participante - eventos inscritos',
            chunks: ['chunk-vendors', 'chunck-common', 'evento-inscritos-participante']
        },
        'gerenciar-evento': {
            entry: './src/views/gerenciar-evento/main.js',
            template: 'public/index.html',
            title: 'Gerenciar eventos',
            chunks: ['chunk-vendors', 'chunck-common', 'gerenciar-evento']
        },
        'gerenciar-usuario-organizador': {
            entry: './src/views/gerenciar-usuario-organizador/main.js',
            template: 'public/index.html',
            title: 'Gerenciar usuario organizador',
            chunks: ['chunk-vendors', 'chunck-common', 'gerenciar-usuario-organizador']
        },
        'home-organizador': {
            entry: './src/views/home-organizador/main.js',
            template: 'public/index.html',
            title: 'Home - Organizador',
            chunks: ['chunk-vendors', 'chunck-common', 'home-organizador']
        },
        'home-participante': {
            entry: './src/views/home-participante/main.js',
            template: 'public/index.html',
            title: 'Home - Participante',
            chunks: ['chunk-vendors', 'chunck-common', 'home-participante']
        },
        'inscricao-participante': {
            entry: './src/views/inscricao-participante/main.js',
            template: 'public/index.html',
            title: 'Edicao de participante por organizador',
            chunks: ['chunk-vendors', 'chunck-common', 'inscricao-participante']
        },
        'lista-participantes-inscritos-organizador': {
            entry: './src/views/lista-participantes-inscritos-organizador/main.js',
            template: 'public/index.html',
            title: 'Lista de participantes inscritos',
            chunks: ['chunk-vendors', 'chunck-common', 'lista-participantes-inscritos-organizador']
        },
        'login': {
            entry: './src/views/login/main.js',
            template: 'public/index.html',
            title: 'Login',
            chunks: ['chunk-vendors', 'chunck-common', 'login']
        },
        'meus-certificados-participante': {
            entry: './src/views/meus-certificados-participante/main.js',
            template: 'public/index.html',
            title: 'Meus certificados',
            chunks: ['chunk-vendors', 'chunck-common', 'meus-certificados-participante']
        },
        'visualizacao-eventos-organizador': {
            entry: './src/views/visualizacao-eventos-organizador/main.js',
            template: 'public/index.html',
            title: 'Visualizar eventos',
            chunks: ['chunk-vendors', 'chunck-common', 'visualizacao-eventos-organizador']
        },
        'visualizacao-eventos-participante': {
            entry: './src/views/visualizacao-eventos-participante/main.js',
            template: 'public/index.html',
            title: 'Visualizacao de eventos',
            chunks: ['chunk-vendors', 'chunck-common', 'visualizacao-eventos-participante']
        },
        'visualizacao-organizador': {
            entry: './src/views/visualizacao-organizador/main.js',
            template: 'public/index.html',
            title: 'Visualizar organizadores',
            chunks: ['chunk-vendors', 'chunck-common', 'visualizacao-organizador']
        },
        'visualizacao-participante': {
            entry: './src/views/visualizacao-participante/main.js',
            template: 'public/index.html',
            title: 'Visualizar participante',
            chunks: ['chunk-vendors', 'chunck-common', 'visualizacao-participante']
        }
    }
}