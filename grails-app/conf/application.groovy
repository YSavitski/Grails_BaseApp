

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'authority.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'authority.UserRole'
grails.plugin.springsecurity.authority.className = 'authority.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/client/index', access: ['ROLE_ADMIN', 'ROLE_USER']],
	[pattern: '/client/show/**', access: ['ROLE_ADMIN', 'ROLE_USER']],

	[pattern: '/client/create', access: ['ROLE_ADMIN']],
	[pattern: '/client/save', access: ['ROLE_ADMIN']],
	[pattern: '/client/upload', access: ['ROLE_ADMIN']],
	[pattern: '/client/edit/**', access: ['ROLE_ADMIN']],
	[pattern: '/client/update/**', access: ['ROLE_ADMIN']],
	[pattern: '/client/delete/**', access: ['ROLE_ADMIN']]

]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

