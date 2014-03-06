/**
 * Copyright (c) 2013-2014, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.github;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.lang.reflect.Modifier;
import java.util.Set;
import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test for visibility.
 * Checks that there are not public classes in package
 * {@code com.jcabi.github}.
 *
 * @author Carlos Crespo (carlos.a.crespo@gmail.com)
 * @version $Id$
 * @todo #604 Make sure that all classes/interfaces not included in the
 *  SKIP set not public and then remove the Ignore annotation.
 */
public final class VisibilityTest {

    /**
     * Set of classes/interfaces that can be public.
     */
    private static final Set<String> SKIP = ImmutableSet.<String>builder()
        .add("com.jcabi.github.Assignees")
        .add("com.jcabi.github.Blobs")
        .add("com.jcabi.github.Bulk")
        .add("com.jcabi.github.Collaborators")
        .add("com.jcabi.github.Comment")
        .add("com.jcabi.github.Comments")
        .add("com.jcabi.github.Commit")
        .add("com.jcabi.github.Commits")
        .add("com.jcabi.github.CommitsComparison")
        .add("com.jcabi.github.Content")
        .add("com.jcabi.github.Contents")
        .add("com.jcabi.github.Coordinates")
        .add("com.jcabi.github.DeployKey")
        .add("com.jcabi.github.DeployKeys")
        .add("com.jcabi.github.Event")
        .add("com.jcabi.github.Fork")
        .add("com.jcabi.github.Forks")
        .add("com.jcabi.github.Gist")
        .add("com.jcabi.github.GistComment")
        .add("com.jcabi.github.GistComments")
        .add("com.jcabi.github.Gists")
        .add("com.jcabi.github.Git")
        .add("com.jcabi.github.Github")
        .add("com.jcabi.github.Gitignores")
        .add("com.jcabi.github.Hook")
        .add("com.jcabi.github.Hooks")
        .add("com.jcabi.github.Issue")
        .add("com.jcabi.github.IssueLabels")
        .add("com.jcabi.github.Issues")
        .add("com.jcabi.github.JsonPatchable")
        .add("com.jcabi.github.JsonReadable")
        .add("com.jcabi.github.Label")
        .add("com.jcabi.github.Labels")
        .add("com.jcabi.github.Limit")
        .add("com.jcabi.github.Limits")
        .add("com.jcabi.github.Markdown")
        .add("com.jcabi.github.Milestone")
        .add("com.jcabi.github.Milestones")
        .add("com.jcabi.github.Organization")
        .add("com.jcabi.github.Organizations")
        .add("com.jcabi.github.PublicKey")
        .add("com.jcabi.github.PublicKeys")
        .add("com.jcabi.github.Pull")
        .add("com.jcabi.github.PullComment")
        .add("com.jcabi.github.PullComments")
        .add("com.jcabi.github.Pulls")
        .add("com.jcabi.github.Reference")
        .add("com.jcabi.github.References")
        .add("com.jcabi.github.Release")
        .add("com.jcabi.github.ReleaseAsset")
        .add("com.jcabi.github.ReleaseAssets")
        .add("com.jcabi.github.Releases")
        .add("com.jcabi.github.Repo")
        .add("com.jcabi.github.RepoCommit")
        .add("com.jcabi.github.RepoCommits")
        .add("com.jcabi.github.Repos")
        .add("com.jcabi.github.Search")
        .add("com.jcabi.github.Tags")
        .add("com.jcabi.github.Trees")
        .add("com.jcabi.github.User")
        .add("com.jcabi.github.UserEmails")
        .add("com.jcabi.github.Users")
        .add("com.jcabi.github.RtGithub")
        .add("com.jcabi.github.mock.MkStorage")
        .build();

    /**
     * ClasspathRule.
     * @checkstyle VisibilityModifierCheck (3 lines)
     */
    @Rule
    public final transient ClasspathRule classpath = new ClasspathRule();

    /**
     * Test for visibility.
     * Checks that there are not public classes in package
     * {@code com.jcabi.github}.
     *
     * @throws Exception If some problem inside
     */
    @Test
    @Ignore
    public void checkVisibility() throws Exception {
        MatcherAssert.assertThat(
            Iterables.filter(
                this.classpath.allTypes(),
                new Predicate<Class<?>>() {
                    @Override
                    public boolean apply(final Class<?> input) {
                        return !SKIP.contains(input.getName());
                    }
                }
            ),
            Matchers.everyItem(
                new CustomTypeSafeMatcher<Class<?>>("not public type") {
                    @Override
                    protected boolean matchesSafely(final Class<?> item) {
                        return !Modifier.isPublic(item.getModifiers());
                    }
                }
            )
        );
    }

}
