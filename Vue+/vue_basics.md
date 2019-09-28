(Vue JS Crash Course - 2019)[https://www.youtube.com/watch?v=Wy9q22isx3U]
(Vuex Crash Course | State Management)[https://www.youtube.com/watch?v=5lVQgZzLMHc]

# misc
- vue has got a ui for deployement and monitorin purpose that have a alot of features like dependenc management, plugins ..., check it out
- export default - exports the current component alongwith data and properties of that component
- then we have tp include porps that we want to be inject from the caller of this component
- when we put scoped attribute in style tag of a component, it limits the css to that particular component only
- we can use <form @submit.prevent="addTodo"> invokes addTodo method and also prevents defaut html page submit action at the same time
- we can validate props and also mark them as required
- instead of v-bind:something we can directly use :bind


# starting a vue poject
-	## install node,npm and yarn (generally once per os)
	- install nvm from [NVM GitHub](https://github.com/nvm-sh/nvm#installation-and-update)
	- `nvm install node`
	- restart terminal
	- install yarn from [yarnpkg.com](https://yarnpkg.com/en/docs/install)

-	## initiate vue project (generally once per project)
	````bash
	npm install -g @vue/cli
	vue create <app-name>
	cd <app-name>
	yarn serve
	````
- add all dependencies like babel, eslint, vue-router etc before starting development
- happy development
- NOTE : Tested on mint, works on windows wsl too but hot reload won't work


# helpers
- vue have vuex as a state management library that works with vue
- we have vue.js devtools as chrome extension to view and debug our vue app in chrome
- we have vetur as a vscode extension for easing vue developmet
	- after installing just write scaffold and hit tab and it will generate all three tags in a component
- try prettier extension
# vue router
- when using router we use router-link tag instead of usual a tag of html
- allows mapping of path with components
- also alows lazy loading (importing of component), so that a component is loaded only when it is requested
- when a component is invoked by router we can acces the parameter (those seperated by /) by using this.$route.params.var
- when a component is invoked by router we can acces the query parameter (those seperated by ?) by using this.$route.query.var
- we can do redirects by this.$router.push()

# vuex | state management 
- as there are multiple components that include or use other components, it creates a hierarchy of componets at different levels
- as we saw in vuejs crash course where state from totoitem component had to propogate through addtodo component to main app component
- now imagine instead of 2 there are n components in between, this creates mess and managing state very hard
- no need to pass events up ⬆ and props down ⬇ through multiple components
- to simplify this we use vues, a central component managemnet strategy via vuex
- similar to redux and flux but is easier
- the gl🌍bal state is *reactive* 
- ## steps
  - create a folder named "store", inside that create index.js
  - load vuex
    - `Vue.use(Vuex)`
  - create store
		````
		export default new Vuex.Store({
			modules:{
				//list modules
			}
		})
		````
	- import store in main.js
	- add store to new Vue before render
	- create modules inside store for each component
  	- this files will consist state, getters, actions, mutations of the components
	- state will be filled by your mutations
	- we dont call mutations directly, instead we commit from action to invoke the mutation
	- components will invoke actions, that will perform mutation which will mutate the state
  	- components invoke actions by importing mapActions and then exporting methods inside mapActions and the using them in the template events to invoke actions
	- actions might generally use async await to let the task finish first and then do the mutation

# vue directives
- v-bind:key="value"
	- A = component with some funtionality
	- B = component using A
	- using v-bind in B
		- binds object named "value" from B to prop named "key" in A, so basically "value" from B is injected in A
- v-bind:class="{'class-name':boolean-condition}"
  - applies class names "class-name" to the component if boolean-condition evaluates to true
- v-on
  - used to catch event on a component
  - v-on:change="markComplete"
	- catches change event on radio or checkbox and invokes markComplete method
- v-model
  - v-model="name"
	- here the input tag will be added to the model so when the submit event occurs this input data can be collected
	- data() is used in export to gather the data collected by v-model 
# each component will have 3 tags
- template - output design
- script - logic
- style - css


# whatever that you export in a component can be used at 2 places
- in the template tag of same component, and since the source for that is same component we dont need to import anything
- in other component, since the source is at different place we first need to import the component and then use it



# export
- properties 
  - name, methods, props, created, computed
  	- and other that can be found in documentation
- methods
  - data()

# data
- if we want to use data for internal purpose we just use data() in export of a component
- if we want to take input from user we still use data() in export of a component and also bind that to the input via v-model="name-of-var"
- if we want data to be accesible or injected from outside we use props

# axios
- we have get, post, delete .. methods
- provides promise based structure
- easy to use


