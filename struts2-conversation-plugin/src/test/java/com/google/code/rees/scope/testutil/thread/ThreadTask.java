/***********************************************************************************************************************
 *
 * Struts2-Conversation-Plugin - An Open Source Conversation- and Flow-Scope Solution for Struts2-based Applications
 * =================================================================================================================
 *
 * Copyright (C) 2012 by Rees Byars
 * http://code.google.com/p/struts2-conversation/
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************
 *
 * $Id: ThreadTask.java Apr 15, 2012 8:31:49 PM reesbyars $
 *
 **********************************************************************************************************************/
package com.google.code.rees.scope.testutil.thread;

/**
 * This interface provides a simple mechanism that can be implemented for adding tasks to a {@link TaskThread}
 * 
 * @author rees.byars
 */
public interface ThreadTask {

	/**
	 * indicates whether or not this tasks {@link #doTask()} method should continue to be called
	 * by its {@link TaskThread}
	 * @return
	 */
	public boolean isActive();

	/**
	 * Cancels this task, after which calls to {@link #isActive()} return false
	 */
	public void cancel();

	/**
	 * The basic task to be performed by this task.  Will continue being called until
	 * {@link #isActive()} returns false or the task is removed from its {@link TaskThread} using
	 * {@link TaskThread#removeTask(ThreadTask)}.  The frequency with which this
	 * task will be executed will be dependent upon the other tasks that are added to the TaskThread.
	 */
	public void doTask();

}
