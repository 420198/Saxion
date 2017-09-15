#ifndef COMMON_H
#define COMMON_H 6.1

/** @file common.h
 * This file contains definitions that are used in various places.
 * Currently:
 * <dl>
 *   <dt>__ECLIPSE__
 *   <dd>Set this to 1 when using eclipse as your ide.
 * </dl>
 */

// If you use eclipse change the 0 into a 1
#define	__ECLIPSE__	0

// MacOS pretends not to be unix ;-)
#if  defined(__APPLE__) && !defined(__unix__)
# define __unix__ 1
#endif

#endif	/*COMMON_H*/

// vim:sw=4:ts=4:ai:aw:
