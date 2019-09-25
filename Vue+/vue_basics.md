(Vue JS Crash Course - 2019)[]

# misc
- vue has got a ui for deployement and monitorin purpose that have a alot of features like dependenc management, plugins ..., check it out
-	export default - exports the current component alongwith data and properties of that component
-	then we have tp include porps that we want to be inject from the caller of this component
- when we put scoped attribute in style tag of a component, it limits the css to that particular component only
- we can use <form @submit.prevent="addTodo"> invokes addTodo method and also prevents defaut html page submit action at the same time
- vue have vuex as a state management framework that works with vue
- we also have vetur as a vscode extension for easing vue developmet

# starting a vue poject
- install vue cli from npm
  - npm install -g @vue/cli
- install all dependencies like babel, eslint, vue-router etc

# vue router
- when using router we use router-link tag instead of usual a tag of html
- allows mapping of path with components
- also alows lazy loading (importing of component), so that a component is loaded only when it is requested

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
    - here the input tag having name="name" will be added to the model so when the submit event occurs this input data can be collected
    - data() is used in export to gather the data collected by v-model 
# each component will have 3 tags
- template - output design
- script - logic
- style - css


# whatever that you export in a component can be used at 2 places
- in the template tag of same component, and since the source for that is same component we dont need to import anything
- in other component, since th source is at different place we first need to import the component and then use it




the data() in export is used to collect and return data attached by v-model which is generally input from the user


# data
- if we want to use data for internal purpose we just use data() in export of a component
- if we want to take input from user we still use data() in export of a component and also bind that to the input field via name using v-model="name-given-to-input"
- if we want data to be accesible or injected from outside we use props

# axios
- we have get, post, delete .. methods
- provides promise based structure
- easy to use


