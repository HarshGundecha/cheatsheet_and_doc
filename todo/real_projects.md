- [Projects](#projects)
	- [tinyurl app / redirection app](#tinyurl-app--redirection-app)
		- [requirements](#requirements)
	- [blogging app](#blogging-app)
		- [requirements](#requirements-1)
		- [brainstorm](#brainstorm)
			- [Solutions](#solutions)
				- [branch based](#branch-based)
		- [how to](#how-to)
			- [technologies](#technologies)

# Projects

## tinyurl app / redirection app

### requirements
- given a link generate a short random link to the given link
- when the original link changes there should be an interface to update that
- so the real goal is to use this wrapper link(random generated one) by referers
    - and when the real link changes they dont need to worry, just the actor updates the link at this app

## blogging app

### requirements
- to be able to use my [cheatsheet_and_doc](https://github.com/HarshGundecha/cheatsheet_and_doc) as blogs
- also make sure to make it portabele so that others can pick it too
- show author name from git owner or git commits
- show last updated time from last git commit on master branch
- show article added time from 1st commit on master branch

### brainstorm
- how to let an article be published
- also how to distinguish between finished and WIP articles since both resides in same repo

#### Solutions

##### branch based
- the idea is to keep finished articles at master branch
- unfinished to WIP
- if a finished article needs update 
  - fork it in a branch
  - make changes->push to master
    - the article gets updated

### how to
- the finished and WIP files can be picked from
  - [github-dummy-repo - master branch](https://github.com/dummy-repo/tree/master)
  - [github-dummy-repo - WIP branch](https://github.com/dummy-repo/tree/WIP)

#### technologies
- frontend
  - vuejs+nuxtjs
- commenting system
  - disqus
- template
  - adminlte-latest
- articles
  - any github repo(for now mine own)