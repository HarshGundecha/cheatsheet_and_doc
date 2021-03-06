# git
- install git according to the system, make sure the git runs on CLI

- git setup
	- use "git config" to configure your git environment, it uses following levels as switch
		- global	// all user, all repo
		- system	// current user, all repo, this seems to be default if no level is passed with "git config"
		- local		// current user, current repo
		// each level overrides configuration of previous level
	- usage "git config --level ..." //where level could be one of the above
	- e.g., "git config --global ..."

- read environment setup
	- git config --list --show-origin
	//shows the path from which the config is read, useful in case of conflicts

- your identity
	- The first thing you should do when you install Git is to set your user name and email address. This is important because every Git commit uses this information, and it’s immutably baked into the commits you 
	- set identity
		- git config --global user.name "your_git_username_here"
		- git config --global user.email johndoe@example.com

- your editor
	- git config --global core.editor emacs
	- git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -nosession"
	//to set editor to notepad++
	- invoke editor	to test
		- git config [--level] -e 
		//might need you to be in a git project directory

- check your settings
	- git config [--level] --list
	OR individual setting
	- git config [--level] user.name

- initialize git
	- either clone existing git project
		- git clone https://github.com/user/repo-name
		OR
		- git clone https://github.com/user/repo-name repo-name2
		//this will clone with the new name "repo-name2" instead of default original repo name
	OR
	- setup version control on existing project by changing current directory 
		to the project's root directory in local machine and executing "git init"
		- This creates a new subdirectory named .git inside project directory that contains all of your necessary repository files — a Git repository skeleton. 
		- add existing files to track them from now onwards
			- git add .
			// adds all files, to add specific file use "git add file_name"
		- commit(initial commit, since git is just inialised)
			- git commit -m "commit message"
			//commits all files that are modified and staged for next commit

- file status
	- untracked
		- git doesnt do version control on these files
	- tracked
		- unmodified	//as it was in previous commit or when last checked out
		- modified	//file is modified but will not be commited in next commit
		- staged	//the file that will be commited in next commit

		- ususal sequence
			->untracked->tracked->unmodified
				->modified->staged->unmodified
				->modified 											//wont be commited
				->modified->staged->unmodified
				...
			->commit
			//only staged files will be commited, note : the modified but unstaged files wont be commited

- check working tree status
	- git status
	//lets you know
		- working branch
		- staged files | files that will be commited on next commit
		- modified files | unstaged file
		- untracked files
	OR
	- git status -s
		// shorted description
		- prefixes
			- A - indicates that file is added to staging area
			- M - indicates modified files
			- ?? - indicates untracked(newly added) file
		
- ignoring files
	- Often, you’ll have a class of files that you don’t want Git to automatically add or even show you as being untracked.
	- These are generally automatically generated files such as log files or files produced by your build system.
	- In such cases, you can create a file listing patterns to match them, named .gitignore. 
	- Here is an example .gitignore file
		- "cat .gitignore"
				# ignores all the object files or archive files, as object are generated machine dependently
				*.[oa
				
				# ignores all temporary files generated in  typical C make
				*~
				
				# ignore all .a files
				*.a

				# but do track lib.a, even though you're ignoring .a files above
				!lib.a

				# only ignore the TODO file in the current directory, not subdir/TODO
				/TODO

				# ignore all files in any directory named build
				build/

				# ignore doc/notes.txt, but not doc/server/arch.txt
				doc/*.txt

				# ignore all .pdf files in the doc/ directory and any of its subdirectories
				doc/**/*.pdf

- detailed info of staged and unstaged files
	- git diff
		- for unstaged files
	- git diff --staged
	OR
	- git diff --cached
		- for staged files

- commiting changes
	- once staged now you can commit your changes, Remember that anything that is still unstaged — any files you have created or modified that you haven’t run "git add" on since you edited them — won’t go into this commit.
	- git commit
	// will open up currenly set editor to enter commit message
	OR
	- alternatively you can use
		- git commit -m "commit message"
	OR
	- if you want to do both "git add" and "git commit" together add -a switch as below
		- git commit -a -m "commit message"
	//note : do this only if you want to stage and commit all of the tracked and modified files

	- removing file from git
		- git rm file_name
		//removes file from git as well as from HDD
		- git rm -chached file_name
		//removes file from git but keeps in HDD
		//useful when a file was tracked mistakenly and now you need to untrack, so untrack it than add it to gitignore to prevent it from getting tracked in future staging

- moving or renaming file
	- git mv old_file_name new_file_name

- logs of commit history
	- git log
	// theres a lot more that isnt covered here, lookout the at
	//https://git-scm.com/book/en/v2/Git-Basics-Viewing-the-Commit-History

- undoing things
	- adding files to previous commit
		- to add files to previous commit without making new commit use following
			- git commit --amend
			//first stage files and than use above command
	- unstage a file, to prevent it from getting committed from next commit (when staged mistakenly)
		- git reset HEAD <file_name>
	- discard changes in a file, take file to previous commit state
		- git checkout -- <file_name>

- checking remotes
	- git remote
	// shows remotes
	- git remote -v
	// shows remotes with url
	- git remote show origin
	// shows origin remote

- adding remote
	- git remote add <remote_name> <existing_repo_url>
	// after adding check the remote by "git remote -v"

- fetching content from remote, not merging
	- git fetch <remote_name>

- pushing to remote
	- git push <remote_name> <branch_name>

- renaming remote
	- git remote rename <current_remote_name> <new_remote_name>

- removing remote
	- git remote remove <remote_name>

-tag
	- tag is not covered here
	// refer https://git-scm.com/book/en/v2/Git-Basics-Tagging


- creating aliases
	- create short alias for longer or often used commands as follows
		- git config --<level> alias.<alias_name> 'your_git_command_here'
		- e.g.
			- alias
				- git config --global alias.unstage 'reset HEAD --'
			- usage
				- git unstage fileA
				// equivalent to "git reset HEAD -- fileA"
	- to create alias to an external command that works with git or something, prefix actual command with !
	- e.g., git config --global alias.visual '!gitk'
	// will run "gitk" command on executing "visual" command
