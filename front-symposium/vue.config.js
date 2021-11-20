module.exports= {
    pages: {
        'cadastro-edicao-evento': {
            entry: './src/views/cadastro-edicao-evento/main.js',
            template: 'public/index.html',
            title: 'Cadastro/Edicao de evento',
            chunks: ['chunk-vendors', 'chunk-common', 'cadastro-edicao-evento']
        },
        'cadastro-participante': {
            entry: './src/views/cadastro-participante/main.js',
            template: 'public/index.html',
            title: 'Cadastro de participante',
            chunks: ['chunk-vendors', 'chunk-common', 'cadastro-participante']
        },
        'edicao-organizador': {
            entry: './src/views/edicao-organizador/main.js',
            template: 'public/index.html',
            title: 'Edicao de organizador',
            chunks: ['chunk-vendors', 'chunk-common', 'edicao-organizador']
        },
        'edicao-participante': {
            entry: './src/views/edicao-participante/main.js',
            template: 'public/index.html',
            title: 'Edicao de participante',
            chunks: ['chunk-vendors', 'chunk-common', 'edicao-participante']
        },
        'edicao-participante-por-organizador': {
            entry: './src/views/edicao-participante-por-organizador/main.js',
            template: 'public/index.html',
            title: 'Edicao de participante por organizador',
            chunks: ['chunk-vendors', 'chunk-common', 'edicao-participante-por-organizador']
        },
        'eventos-inscritos-participante': {
            entry: './src/views/eventos-inscritos-participante/main.js',
            template: 'public/index.html',
            title: 'Participante - eventos inscritos',
            chunks: ['chunk-vendors', 'chunk-common', 'eventos-inscritos-participante']
        },
        'gerenciar-evento': {
            entry: './src/views/gerenciar-evento/main.js',
            template: 'public/index.html',
            title: 'Gerenciar eventos',
            chunks: ['chunk-vendors', 'chunk-common', 'gerenciar-evento']
        },
        'gerenciar-participantes-organizador': {
            entry: './src/views/gerenciar-participantes-organizador/main.js',
            template: 'public/index.html',
            title: 'Gerenciar participantes',
            chunks: ['chunk-vendors', 'chunk-common', 'gerenciar-participantes-organizador']
        },
        'home-organizador': {
            entry: './src/views/home-organizador/main.js',
            template: 'public/index.html',
            title: 'Home - Organizador',
            chunks: ['chunk-vendors', 'chunk-common', 'home-organizador']
        },
        'home-participante': {
            entry: './src/views/home-participante/main.js',
            template: 'public/index.html',
            title: 'Home - Participante',
            chunks: ['chunk-vendors', 'chunk-common', 'home-participante']
        },
        'inscricao-participante': {
            entry: './src/views/inscricao-participante/main.js',
            template: 'public/index.html',
            title: 'Edicao de participante por organizador',
            chunks: ['chunk-vendors', 'chunk-common', 'inscricao-participante']
        },
        'lista-participantes-inscritos-organizador': {
            entry: './src/views/lista-participantes-inscritos-organizador/main.js',
            template: 'public/index.html',
            title: 'Lista de participantes inscritos',
            chunks: ['chunk-vendors', 'chunk-common', 'lista-participantes-inscritos-organizador']
        },
        'login': {
            entry: './src/views/login/main.js',
            template: 'public/index.html',
            title: 'Login',
            chunks: ['chunk-vendors', 'chunk-common', 'login']
        },
        'meus-certificados-participante': {
            entry: './src/views/meus-certificados-participante/main.js',
            template: 'public/index.html',
            title: 'Meus certificados',
            chunks: ['chunk-vendors', 'chunk-common', 'meus-certificados-participante']
        },
        'visualizacao-eventos-organizador': {
            entry: './src/views/visualizacao-eventos-organizador/main.js',
            template: 'public/index.html',
            title: 'Visualizar eventos',
            chunks: ['chunk-vendors', 'chunk-common', 'visualizacao-eventos-organizador']
        },
        'visualizacao-eventos-participante': {
            entry: './src/views/visualizacao-eventos-participante/main.js',
            template: 'public/index.html',
            title: 'Visualizacao de eventos',
            chunks: ['chunk-vendors', 'chunk-common', 'visualizacao-eventos-participante']
        },
        'visualizacao-organizador': {
            entry: './src/views/visualizacao-organizador/main.js',
            template: 'public/index.html',
            title: 'Visualizar organizadores',
            chunks: ['chunk-vendors', 'chunk-common', 'visualizacao-organizador']
        },
        'visualizacao-participante': {
            entry: './src/views/visualizacao-participante/main.js',
            template: 'public/index.html',
            title: 'Visualizar participante',
            chunks: ['chunk-vendors', 'chunk-common', 'visualizacao-participante']
        },
        'acesso-negado': {
          entry: './src/views/acesso-negado/main.js',
          template: 'public/index.html',
          title: 'Acesso negado',
          chunks: ['chunk-vendors', 'chunk-common', 'acesso-negado']
        }
    }
}
